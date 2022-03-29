package com.grpc.client;

import com.grpc.orderService.OrdersServer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import com.grpc.orderService.*;
import com.grpc.warehouseService.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ClientController implements ActionListener {

public static String[] products;
public  static Stock[] stocks;

    JTextField entry4, reply4;


    public static void main(String[] args) throws IOException {
        System.out.println("Hello im a GRPC Client");

        //channel for transporting data
        System.out.println("Creating Stub");
        ClientController main = new ClientController();

        WarehouseServer ws = new WarehouseServer();

        Stock[] stock = ws.makeDatabase();

        products = new String[stock.length];

        System.out.println(stock[0]);

        for(int i = 0; i < stock.length; i++){
            products[i] = stock[i].getProductName();
        }


        main.build();
        main.run();
    }

    private void run() {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext() //forces ssl to stop (do not use during development
                .build();

//        System.out.println(WarehouseServer.stocks[10]);

//        doUnaryCall(channel);
        checkStockLevels(channel);

        //do something
        System.out.println("Shutting down channel");
        channel.shutdown();
    }

    private void build(){

        JFrame frame = new JFrame("Service Controller Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add( getQuote() );


        // Set size for the frame
        frame.setSize(300, 300);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }

    private JPanel getQuote(){

        JPanel panel = new JPanel(new GridLayout(2,3));

        JList jList;
        JList jListForCopy;
        JButton copyButton;

        jList = new JList(products);
        jList.setFixedCellHeight(15);
        jList.setFixedCellWidth(100);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setVisibleRowCount(20);
        panel.add(new JScrollPane(jList));

        jListForCopy = new JList();
        jListForCopy.setFixedCellHeight(15);
        jListForCopy.setFixedCellWidth(100);
        jList.setVisibleRowCount(20);
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        panel.add(new JScrollPane(jListForCopy));

        copyButton = new JButton("Move selected items");
        panel.add(copyButton);

        copyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jListForCopy.setListData(jList.getSelectedValues());
            }
        });



//        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);


//        JLabel label = new JLabel("Choose a product\n");
//        panel.add(label);
//        panel.add(Box.createRigidArea(new Dimension(10, 0)));
//        JComboBox<String> jComboBox = new JComboBox<String>(products);
//        panel.add(jComboBox);
//        panel.add(Box.createRigidArea(new Dimension(10, 0)));
//
//        JLabel quantiyLabel = new JLabel("Quantity: ");
//        entry4 = new JTextField("", 10);
//        panel.add(Box.createRigidArea(new Dimension(10, 0)));
//
//        entry4 .setEditable(true);
//        panel.add(quantiyLabel);
//        panel.add(entry4 );
//        panel.add(Box.createRigidArea(new Dimension(10, 0)));


//        JButton button = new JButton("");
//        button.addActionListener(this);
//        panel.add(button);
//        panel.add(Box.createRigidArea(new Dimension(10, 0)));



//        panel.setLayout(boxlayout);

        return panel;
    }



    private void checkStockLevels(ManagedChannel channel) {
        //create a client or stub
        //do not use blocking stub becasue LongGreet is streaming so it needs to be asynchronas
        //just use serviceStub

        //countdown latch
        CountDownLatch latch = new CountDownLatch(1);

        //async client
        orderServiceGrpc.orderServiceStub asyncClient = orderServiceGrpc.newStub(channel);

        StreamObserver<StockQuoteRequest> requestObserver = asyncClient.streamStockQuote(
                new StreamObserver<StockQuoteResponse>() {
                    @Override
                    public void onNext(StockQuoteResponse value) {
                        //we get a response from the server
                        System.out.println("Received response from server\n");
                        System.out.println("Quote for requested items:");
                        System.out.println(value.getMessage());
                        System.out.println("Total sum: "+value.getPrice()+"\n");
                        //onNext only called once as its clientStreaming
                    }

                    @Override
                    public void onError(Throwable t) {
                        //we get an error from the server
                    }

                    @Override
                    public void onCompleted() {
                        //server has finished sending data
                        System.out.println("Server has completed actions");
                        latch.countDown();
                    }
                }
        );

        System.out.println("Sending message 1");
        requestObserver.onNext(StockQuoteRequest.newBuilder()
                .setProduct(product.newBuilder()
                        .setCost(69.99f)
                        .build())
                .setQuantity(10)
                .build());

        System.out.println("Sending message 2");
        requestObserver.onNext(StockQuoteRequest.newBuilder()
                        .setProduct(product.newBuilder()
                                .setCost(200.99f)
                                .build())
                .setQuantity(20)
                .build());

        System.out.println("Sending message 3");
        requestObserver.onNext(StockQuoteRequest.newBuilder()
                .setProduct(product.newBuilder()
                        .setCost(20.99f)
                        .build())
                .setQuantity(20)
                .build());

        //tell the server that the client is done streaming
        requestObserver.onCompleted();

        try {
            latch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
