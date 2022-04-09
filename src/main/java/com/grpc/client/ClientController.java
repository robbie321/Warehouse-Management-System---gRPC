package com.grpc.client;

import com.grpc.orderService.orderRequest;
import com.grpc.orderService.orderResponse;
import com.grpc.stockCheckerService.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import com.grpc.orderService.*;
import com.grpc.warehouseService.*;

import javax.jmdns.ServiceInfo;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ClientController implements ActionListener {

public static String[] products;
public  static Stock[] stock;

    JTextField entry4, reply4;


    public static void main(String[] args) throws IOException {
        System.out.println("Hello im a GRPC Client");

        //channel for transporting data
        System.out.println("Creating Stub");
        ClientController main = new ClientController();

//        WarehouseServer ws = new WarehouseServer();
//
//       stock = ws.makeDatabase();

//        products = new String[stock.length];

        main.run();
    }

    private void run() {
        String host = "localhost";

        ServiceInfo serviceInfoWarehouse, serviceInfoInventory, serviceInfoOrder;
        String serviceType = "_grpc._tcp.local.";
        //retrieve service info for each service
//        serviceInfoWarehouse = WareHouseServiceDiscovery.runjmDNS(serviceType);
        serviceInfoInventory = InventoryServiceDiscovery.runjmDNS(serviceType);
//        serviceInfoOrder = OrderServiceDiscovery.runjmDNS(serviceType);

//        int warehousePort = serviceInfoWarehouse.getPort();
        int inventoryPort = serviceInfoInventory.getPort();
//        int orderPort = serviceInfoOrder.getPort();

//        ManagedChannel warehouseServiceChannel = ManagedChannelBuilder.forAddress(host, warehousePort)
//                .usePlaintext() //forces ssl to stop (do not use during development
//                .build();
//
        ManagedChannel inventoryServiceChannel = ManagedChannelBuilder.forAddress(host, inventoryPort)
                .usePlaintext() //forces ssl to stop (do not use during development
                .build();

//        ManagedChannel orderServiceChannel = ManagedChannelBuilder.forAddress(host, orderPort)
//                .usePlaintext() //forces ssl to stop (do not use during development
//                .build();

        //OrderService
//        createOrder(orderServiceChannel);
//        filterPrice(orderServiceChannel);
//        produceQuote(orderServiceChannel);

        //InventoryService
//        addProductToStock(inventoryServiceChannel);
//        checkLowStock(inventoryServiceChannel);

        //WarehouseService
//        generateWarehouseReport(warehouseServiceChannel);
//        findOrderByOrderNumber(warehouseServiceChannel);
//        checkLastOrders(warehouseServiceChannel);

    }

    //Automate Orders Service
    private void createOrder(ManagedChannel channel) {

        //create the stub
        orderServiceGrpc.orderServiceBlockingStub stub = orderServiceGrpc.newBlockingStub(channel);

        Scanner in = new Scanner(System.in);
        String product = "";
        int quantity = 0;

        //replace this with a JPanel showing a list the user can choose from
        System.out.print("What product: ");
        product = in.nextLine();
        System.out.print("How many: ");
        quantity = in.nextInt();

        //prepare request
        orderRequest request = orderRequest.newBuilder()
                .setItem(product)
                .setQuantity(quantity)
                .build();

        //response in blocking manner
        orderResponse response = stub.createOrder(request);

        System.out.println(response.getMessage());

    }

    private void produceQuote(ManagedChannel channel) {
        //create a client or stub
        //do not use blocking stub because LongGreet is streaming so, it needs to be async

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
                        System.out.println("Total sum: €"+value.getPrice()+"\n");
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

        int userQuantity = 10;
        for(int i = 0; i < 3; i++){
            System.out.println("Sending message " + i);
            requestObserver.onNext(StockQuoteRequest.newBuilder()
                    .setProduct(product.newBuilder()
                            .setCost(stock[i].getCost())
                            .build())
                    .setQuantity(userQuantity)
                    .build());

            userQuantity += 10;
        }


        //tell the server that the client is done streaming
        requestObserver.onCompleted();

        try {
            latch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void filterPrice(ManagedChannel channel) {

        //create the stub
        orderServiceGrpc.orderServiceBlockingStub stub = orderServiceGrpc.newBlockingStub(channel);

        //prepare request
        FilterPriceRequest priceRequest = FilterPriceRequest.newBuilder()
                        .setMaxPrice(55).build();

        //stream response in blocking manner
        stub.filterPrice(priceRequest).forEachRemaining(filterPriceResponse -> {
            System.out.println(filterPriceResponse.getProduct()); //let this equal text field to display
        });
    }

    //Inventory Management Service
    private void checkLowStock(ManagedChannel inventoryServiceChannel) {

        Scanner in = new Scanner(System.in);

        //create stub
        inventoryCheckerServiceGrpc.inventoryCheckerServiceBlockingStub stub = inventoryCheckerServiceGrpc.newBlockingStub(inventoryServiceChannel);

        int quantity = 0;

        System.out.println("Enter quantity of stock: ");
        quantity = in.nextInt();

        //prepare request
        lowStockRequest request = lowStockRequest.newBuilder()
                .setQuantity(quantity)
                .build();

        //respond
        stub.checkLowStock(request).forEachRemaining(lowStockResponse -> {
            System.out.println(lowStockResponse.getMessage());
        });

        //do something
        System.out.println("\nShutting down channel");
        inventoryServiceChannel.shutdown();
    }

    private void addProductToStock(ManagedChannel inventoryServiceChannel) {
        //create stub
        inventoryCheckerServiceGrpc.inventoryCheckerServiceBlockingStub stub
                = inventoryCheckerServiceGrpc.newBlockingStub(inventoryServiceChannel);

        Scanner sc = new Scanner(System.in);

        //regex to check if user entered values meet criteria
        String regex = "^[a-zA-Z]+$";
        String floatRegex = "^[+-]?([0-9]*[.])?[0-9]+$";

        String productName = "";
        String cost = "";
        String quantityAvailable = "";

        float cst=0;
        int quantity = 0;


        System.out.println("Product name: ");
        productName = sc.nextLine();
        validate(regex, productName);


        System.out.println("Product cost: ");
        cost = sc.nextLine();
        validate(floatRegex,cost);
        cst = Float.parseFloat(cost);


        System.out.println("How many in stock: ");
        quantityAvailable = sc.nextLine();
        validate(floatRegex,quantityAvailable);
        quantity = Integer.parseInt(quantityAvailable);


        //prepare request
        addStockRequest request = addStockRequest.newBuilder()
                .setProductName(productName)
                .setCost(cst)
                .setQuantityAvailable(quantity)
                .build();

        //response
        addStockResponse response = stub.addProductsToStock(request);

        System.out.println(response.getMessage());


        //do something
        System.out.println("\nShutting down channel");
        inventoryServiceChannel.shutdown();
    }

    private void validate(String regex, String string) {
        //throw error if condition is met
        if(!string.matches(regex))
            throw new RuntimeException(string + " is not a valid entry!");

    }

    //Update Warehouse Service
    private void generateWarehouseReport(ManagedChannel channel){
        //create the stub
        warehouseServiceGrpc.warehouseServiceBlockingStub stub = warehouseServiceGrpc.newBlockingStub(channel);

        Scanner sc = new Scanner(System.in);

        String date = "";
        String dateRegex = "^\\d{2}/\\d{2}/\\d{4}$";

        System.out.println("Enter a date dd/mm/yyyy");
        date = sc.nextLine();

        //valid date
        boolean valid = false;

        //if checkDate completes, set valid to true,
        //else print error message and ask again
        while (!valid){
            try{
                validateDate(dateRegex, date);
                valid = true;
            }catch (InputMismatchException e){
                System.out.println(e.getLocalizedMessage());
                date = sc.nextLine();
            }
        }

        sc.close();

        //prepare request
        reportRequest request = reportRequest.newBuilder()
                .setDate(date)
                .build();

        //generate response
        stub.generateReportStream(request).forEachRemaining(reportResponse -> {
            System.out.print(reportResponse.getMessage()); //let this equal text field
        });
    }

    //validate, custom error (Question 2.3)
    private void validateDate(String regex, String string) {
        //throw error if condition is met
        if(!string.matches(regex))
            throw new InputMismatchException(string + " does not match the format dd/mm/yyyy");
    }

    private void findOrderByOrderNumber(ManagedChannel warehouseServiceChannel) {

        //create stub
        warehouseServiceGrpc.warehouseServiceBlockingStub stub = warehouseServiceGrpc.newBlockingStub(warehouseServiceChannel);

        Scanner sc = new Scanner(System.in);

        String orderNumber = "";

        System.out.println("Enter order number: ");
        orderNumber = sc.nextLine();

        sc.close();

        //prepare request
        orderNumberRequest request = orderNumberRequest.newBuilder()
                .setOrderNumber(orderNumber)
                .build();

        //prepare response
        orderNumberResponse response = stub.reportAnOrder(request);

        System.out.println(response.getOrder());

        //do something
        System.out.println("\nShutting down channel");
        warehouseServiceChannel.shutdown();
    }

    private void checkLastOrders(ManagedChannel warehouseServiceChannel){
            CountDownLatch latch = new CountDownLatch(1);

        Scanner sc = new Scanner(System.in);

        int amountOfOrders = 0;

        System.out.print("Enter the amount of orders to print: ");
        amountOfOrders = sc.nextInt();

        sc.close();

        //async client
        warehouseServiceGrpc.warehouseServiceStub asyncStub = warehouseServiceGrpc.newStub(warehouseServiceChannel);

        StreamObserver<lastOrdersRequest> requestObserver = asyncStub.checkLastOrders(
                new StreamObserver<lastOrdersResponse>() {
                    @Override
                    public void onNext(lastOrdersResponse value) {
                        System.out.println(value.getProducts());
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.getMessage();
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Server finished sending data!");
                        latch.countDown();
                    }
                }
        );

        String result = "";

        for(int i = stock.length - amountOfOrders; i <= stock.length - 1; i++){
//            System.out.println("Sending product: " + stock[i]);

            requestObserver.onNext(lastOrdersRequest.newBuilder().setProduct(product.newBuilder()
                    .setProductName(stock[i].getProductName())
                    .setCost(stock[i].getCost())
                    .setQuantityAvailable(stock[i].getQuantity_available()))
                    .build());

        }

        System.out.println("The last " + amountOfOrders + " orders are: ");


        requestObserver.onCompleted();

        try {
            latch.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //do something
        System.out.println("\nShutting down channel");
        warehouseServiceChannel.shutdown();

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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
