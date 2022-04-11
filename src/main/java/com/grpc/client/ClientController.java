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

        WarehouseServer ws = new WarehouseServer();

        stock = ws.makeDatabase();

        products = new String[stock.length];

        main.build();
    }

    //Automate Orders Service
    private void createOrder(ManagedChannel channel) {

        //create the stub
        orderServiceGrpc.orderServiceBlockingStub stub = orderServiceGrpc.newBlockingStub(channel);

        //regex to check if user entered values meet criteria
        String regex = "^[a-zA-Z]+$";
        String floatRegex = "^[+-]?([0-9]*[.])?[0-9]+$";

        //validate user input
        String product = validateString("Enter a product: ", regex);
        String Quantity = validateString("How many to order: ",floatRegex);
        int quantity = Integer.parseInt(Quantity);

        //prepare request
        orderRequest request = orderRequest.newBuilder()
                .setItem(product)
                .setQuantity(quantity)
                .build();

        //response in blocking manner
        orderResponse response = stub.createOrder(request);

        //print to user
        JOptionPane.showMessageDialog(null,response.getMessage());

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



        //format string
        String formatStr = "%-" + 30 + "s   %-"+30+"s" +"%-"+30+"s\n";


        System.out.format(formatStr,"Row 1","Row 2","Row 3");
        System.out.println("-------------------------------------------------------------------------------------------------");
        //choose from list
        for(int i = 0; i < stock.length -4; i+=3){
            System.out.format(formatStr,"["+i+"]" + stock[i].getProductName() + ", €" + stock[i].getCost(),
                        "["+(i+1)+"]" + stock[i+1].getProductName() + ", €" + stock[i+1].getCost(),
                        "["+(i+2)+"]" + stock[i+2].getProductName() + ", €" + stock[i+2].getCost());
        }

        String regex = "^[0-9]+";

        //get user input
        String Product = validateString("Enter a number from the list: ",regex);
        int productNo = Integer.parseInt(Product);
        String Quantity = "";
        int quantity = 0;

        if(productNo > stock.length)
            throw new ArrayIndexOutOfBoundsException("No such product exists");
        else{
            Quantity = validateString("Quantity: ", regex);
            quantity = Integer.parseInt(Quantity);
        }

        //generate response
        requestObserver.onNext(StockQuoteRequest.newBuilder()
                .setProduct(product.newBuilder()
                        .setCost(stock[productNo].getCost())
                        .build())
                .setQuantity(quantity)
                .build());

        //tell the server that the client is done streaming
        requestObserver.onCompleted();

        try {
            latch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void filterPrice(ManagedChannel channel) {

        String floatRegex = "^[+-]?([0-9]*[.])?[0-9]+$";

        //create the stub
        orderServiceGrpc.orderServiceBlockingStub stub = orderServiceGrpc.newBlockingStub(channel);

        //get filtered value
        String maxPrice = validateString("Enter max value: ",floatRegex);
        int max_price = Integer.parseInt(maxPrice);

        //prepare request
        FilterPriceRequest priceRequest = FilterPriceRequest.newBuilder()
                        .setMaxPrice(max_price).build();

        //stream response in blocking manner
        stub.filterPrice(priceRequest).forEachRemaining(filterPriceResponse -> {
            System.out.println(filterPriceResponse.getProduct()); //let this equal text field to display
        });
    }

    //Inventory Management Service
    private void checkLowStock(ManagedChannel inventoryServiceChannel) {

        //create stub
        inventoryCheckerServiceGrpc.inventoryCheckerServiceBlockingStub stub = inventoryCheckerServiceGrpc.newBlockingStub(inventoryServiceChannel);

        //number regex
        String regex = "^[+-]?([0-9]*[.])?[0-9]+$";

        //quantity, convert to int
        int quantity = 0;

        //validate user entry
        String Quantity = validateString("Enter quantity of stock: ", regex);
        quantity = Integer.parseInt(Quantity);

        //prepare request
        lowStockRequest request = lowStockRequest.newBuilder()
                .setQuantity(quantity)
                .build();

        JTextArea list = new JTextArea(35,50);
        list.setEditable(false);

        //respond
        stub.checkLowStock(request).forEachRemaining(lowStockResponse -> {
            list.append(lowStockResponse.getMessage() + "\n");
        });

        JOptionPane.showMessageDialog(null,new JScrollPane(list));


    }

    private void addProductToStock(ManagedChannel inventoryServiceChannel) {
        //create stub
        inventoryCheckerServiceGrpc.inventoryCheckerServiceBlockingStub stub
                = inventoryCheckerServiceGrpc.newBlockingStub(inventoryServiceChannel);

        Scanner sc = new Scanner(System.in);

        //regex to check if user entered values meet criteria
        String regex = "^[a-zA-Z]+$";
        String floatRegex = "^[+-]?([0-9]*[.])?[0-9]+$";

        //new cost and quantity
        float cst=0;
        int quantity = 0;

        //product name
        String productName = validateString("Product name: ", regex);

        //cost, convert to float
        String cost = validateString("Product cost: ",floatRegex);
        cst = Float.parseFloat(cost);

        //quantity available, convert to int
        String quantityAvailable = validateString("How many in stock: ",floatRegex);
        quantity = Integer.parseInt(quantityAvailable);


        //prepare request
        addStockRequest request = addStockRequest.newBuilder()
                .setProductName(productName)
                .setCost(cst)
                .setQuantityAvailable(quantity)
                .build();

        //response
        addStockResponse response = stub.addProductsToStock(request);

        JOptionPane.showMessageDialog(null,response.getMessage());

    }

    private String validateString(String message, String regex) {

        //initialise scanner
//        Scanner in = new Scanner(System.in);

        String result;

        result = JOptionPane.showInputDialog(null,message);

//        System.out.println(message);
//        result = in.nextLine();

        //validate
        boolean valid = false;

        //if validate completes, set valid to true,
        //else print error message and ask again
        while (!valid){
            try{
                validate(regex, result);
                valid = true;

            }catch (InputMismatchException e){
                JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
                result = JOptionPane.showInputDialog(null,message);
            }
        }

        //return result
        return result;
    }

    private void validate(String regex, String string) {
        //throw error if condition is met
        if(!string.matches(regex))
            throw new InputMismatchException(string + " is not a valid entry!");
    }

    //Update Warehouse Service
    private void generateWarehouseReport(ManagedChannel channel){
        //create the stub
        warehouseServiceGrpc.warehouseServiceBlockingStub stub = warehouseServiceGrpc.newBlockingStub(channel);

        String date = "";
        String dateRegex = "^\\d{2}/\\d{2}/\\d{4}$";

        date = JOptionPane.showInputDialog(null,"Enter a date dd/mm/yyyy: ");

        //valid date
        boolean valid = false;

        //if checkDate completes, set valid to true,
        //else print error message and ask again
        while (!valid){
            try{
                validateDate(dateRegex, date);
                valid = true;
            }catch (InputMismatchException e){
                JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
                date = JOptionPane.showInputDialog(null,"Enter a date dd/mm/yyyy: ");
            }
        }


        //prepare request
        reportRequest request = reportRequest.newBuilder()
                .setDate(date)
                .build();

        final String[] result = {""};

        //generate response
        stub.generateReportStream(request).forEachRemaining(reportResponse -> {
            if(reportResponse == null){
                JOptionPane.showMessageDialog(null,"No entries found on this date");
            }else
                result[0] += reportResponse.getMessage() + "\n"; //let this equal text field
        });

        JOptionPane.showMessageDialog(null,result);
    }

    //validate, custom error (Question 2.3)
    private void validateDate(String regex, String string) {
        //throw error if condition is met
        if(!string.matches(regex))
            throw new InputMismatchException(string + " does not match the format dd/mm/yyyy");
    }

    private void findOrderByOrderNumber(ManagedChannel warehouseServiceChannel) {

        String numberRegex = "^[+-]?([0-9]*[.])?[0-9]+$";
        //create stub
        warehouseServiceGrpc.warehouseServiceBlockingStub stub = warehouseServiceGrpc.newBlockingStub(warehouseServiceChannel);


        //validate user input
        String orderNumber = validateString("\nEnter order number: ", numberRegex);


        //prepare request
        orderNumberRequest request = orderNumberRequest.newBuilder()
                .setOrderNumber(orderNumber)
                .build();

        //prepare response
        orderNumberResponse response = stub.reportAnOrder(request);

        //print the order
        System.out.println(response.getOrder());

    }

    private void checkLastOrders(ManagedChannel warehouseServiceChannel){
        //instantiate the latch
        CountDownLatch latch = new CountDownLatch(1);

        //regex for validation
        String numberRegex = "^[+-]?([0-9]*[.])?[0-9]+$";

        //validate user input
        String Amount = validateString("Enter the amount of orders to print: ", numberRegex);
        //cast string to int
        int amountOfOrders = Integer.parseInt(Amount);

        //async client
        warehouseServiceGrpc.warehouseServiceStub asyncStub = warehouseServiceGrpc.newStub(warehouseServiceChannel);

        final String[] result = new String[1];
        //make request
        StreamObserver<lastOrdersRequest> requestObserver = asyncStub.checkLastOrders(
                new StreamObserver<lastOrdersResponse>() {
                    @Override
                    public void onNext(lastOrdersResponse value) {
                        result[0] +=  value.getProducts() + "\n";
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


        //print out the number of orders the client requests. Start the index at the stock amount - amountOfOrders
        for(int i = stock.length - amountOfOrders; i <= stock.length - 1; i++){

            //build the request
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

        JOptionPane.showMessageDialog(null, result[0]);


    }

    private void build(){

        JFrame frame = new JFrame("Stock management system");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel mainPanel = new JPanel();
        JPanel menuPanel = new JPanel();
        JPanel orderPanel = new JPanel();
        JPanel inventoryPanel = new JPanel();
        JPanel warehousePanel = new JPanel();

        //set grid
        GridLayout grid = new GridLayout(0,2);
        GridBagConstraints c = new GridBagConstraints();

        menuPanel.setLayout(grid);
        orderPanel.setLayout(grid);
        inventoryPanel.setLayout(grid);
        warehousePanel.setLayout(grid);

        c.weightx = 1;
        c.weighty = 0.25;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;

        //Menu Buttons
        JButton mainMenuButton = new JButton("Main Menu");
        JButton orderServiceButton = new JButton("Order Service");
        JButton inventoryServiceButton = new JButton("Inventory Service");
        JButton warehouseServiceButton = new JButton("Warehouse Service");
        JButton exitButton = new JButton("Exit");

        //Order buttons
        JButton createOrderButton = new JButton("Make order");
        JButton getQuoteButton = new JButton("Get a quote");
        JButton filterButton = new JButton("Filter Price");

        //Inventory buttons
        JButton checkLowStockButton = new JButton("Check low stock");
        JButton addStockButton = new JButton("Add Product");

        //Warehouse buttons
        JButton generateReportButton = new JButton("Generate Report");
        JButton findOrderButton = new JButton("Find an order");
        JButton printSalesButton = new JButton("Print Sales");

        //Channels
        final ManagedChannel[] orderServiceChannel = {null};
        final ManagedChannel[] inventoryServiceChannel = {null};
        final ManagedChannel[] warehouseServiceChannel = {null};

        //service ingo jmDNS
        String host = "localhost";
        String serviceType = "_grpc._tcp.local.";

        CardLayout cl = new CardLayout();
        mainPanel.setLayout(cl);

        //order panel
        orderPanel.add(createOrderButton,c);
        orderPanel.add(getQuoteButton,c);
        orderPanel.add(filterButton,c);
        orderPanel.add(mainMenuButton,c);

        //Inventory panel
        inventoryPanel.add(checkLowStockButton,c);
        inventoryPanel.add(addStockButton);
        inventoryPanel.add(mainMenuButton,c);
        inventoryPanel.add(exitButton,c);

        //Warehouse panel
        warehousePanel.add(generateReportButton,c);
        warehousePanel.add(findOrderButton,c);
        warehousePanel.add(printSalesButton,c);
        warehousePanel.add(mainMenuButton,c);

        //menu panel
        menuPanel.add(orderServiceButton,c);
        menuPanel.add(inventoryServiceButton,c);
        menuPanel.add(warehouseServiceButton,c);
        menuPanel.add(exitButton,c);

        //container panel
        mainPanel.add(menuPanel,"1");
        mainPanel.add(orderPanel,"2");
        mainPanel.add(inventoryPanel,"3");
        mainPanel.add(warehousePanel,"4");
        cl.show(mainPanel,"1");

        //main menu
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("menu");
                cl.show(mainPanel,"1");
            }
        });
        orderServiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ServiceInfo serviceInfoOrder;

                //retrieve service info for each service
                serviceInfoOrder = OrderServiceDiscovery.runjmDNS(serviceType);

                int orderPort = 50051;
                orderServiceChannel[0] = ManagedChannelBuilder.forAddress(host, orderPort)
                        .usePlaintext() //forces ssl to stop (do not use during development
                        .build();

                JLabel load = new JLabel("Loading jmDNS, please wait....");

                menuPanel.add(load);

                frame.revalidate();
                frame.repaint();

                cl.show(mainPanel,"2");
            }
        });
        inventoryServiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceInfo inventoryService;

                //retrieve service info for each service
                inventoryService = InventoryServiceDiscovery.runjmDNS(serviceType);

                int orderPort = 50053;
                inventoryServiceChannel[0] = ManagedChannelBuilder.forAddress(host, orderPort)
                        .usePlaintext() //forces ssl to stop (do not use during development
                        .build();

                JLabel load = new JLabel("Loading jmDNS, please wait....");

                menuPanel.add(load);

                frame.revalidate();
                frame.repaint();

                cl.show(mainPanel,"3");
            }
        });
        warehouseServiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ServiceInfo serviceInfoWarehouse = WareHouseServiceDiscovery.runjmDNS(serviceType);

                int warehousePort = 50052;

                warehouseServiceChannel[0] = ManagedChannelBuilder.forAddress(host, warehousePort)
                        .usePlaintext() //forces ssl to stop (do not use during development
                        .build();

                cl.show(mainPanel,"4");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Order Menu
        createOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                createOrder(orderServiceChannel[0]);
            }
        });
        getQuoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produceQuote(orderServiceChannel[0]);
            }
        });
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterPrice(orderServiceChannel[0]);
            }
        });

        //Inventory Menu
        checkLowStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkLowStock(inventoryServiceChannel[0]);
            }
        });
        addStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductToStock(inventoryServiceChannel[0]);
            }
        });

        //Warehouse Menu
        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateWarehouseReport(warehouseServiceChannel[0]);
            }
        });
        findOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findOrderByOrderNumber(warehouseServiceChannel[0]);
            }
        });
        printSalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkLastOrders(warehouseServiceChannel[0]);
            }
        });

        // Set border for the panel
        mainPanel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        // Set size for the frame
        frame.setSize(600, 600);

        // Set the window to be visible as the default to be false
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


    private JPanel button(String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1;
        c.weighty = .25;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;

        JButton myButton = new JButton(text);
        myButton.setMargin(new Insets(10,10,10,10));
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Order made");
            }
        });

        panel.add(myButton,c);


        return panel;
    }

    private JPanel createOrder(){
        JPanel jPanel = new JPanel();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1;
        c.weighty = .25;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;

        JTextField product, productReply;
        JTextField quantity, quantityReply;

        JLabel label = new JLabel("Enter product");
        product = new JTextField("",10);

        panel.add(label);
        panel.add(product);

        return  jPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        String label = button.getActionCommand();

        if(label.equals("Close application")){
            System.exit(0);
        }
        else if(label.equals("Order Service")){

            String host = "localhost";

            ServiceInfo serviceInfoOrder;
            String serviceType = "_grpc._tcp.local.";
            //retrieve service info for each service
            serviceInfoOrder = OrderServiceDiscovery.runjmDNS(serviceType);

            int orderPort = 50051;

            ManagedChannel orderServiceChannel = ManagedChannelBuilder.forAddress(host, orderPort)
                    .usePlaintext() //forces ssl to stop (do not use during development
                    .build();
//            OrderService
            createOrder(orderServiceChannel);
            filterPrice(orderServiceChannel);
            produceQuote(orderServiceChannel);
        }
        else if(label.equals("Inventory Service")){
            String host = "localhost";

            String serviceType = "_grpc._tcp.local.";

            ServiceInfo serviceInfoInventory;
            serviceInfoInventory = InventoryServiceDiscovery.runjmDNS(serviceType);
            int inventoryPort = serviceInfoInventory.getPort();

            ManagedChannel inventoryServiceChannel = ManagedChannelBuilder.forAddress(host, inventoryPort)
            .usePlaintext() //forces ssl to stop (do not use during development
            .build();

            //InventoryService
            addProductToStock(inventoryServiceChannel);
            checkLowStock(inventoryServiceChannel);

            //do something
            System.out.println("\nShutting down channel");
            inventoryServiceChannel.shutdown();
        }
        else if(label.equals("Warehouse Service")){
            String host = "localhost";

            ServiceInfo serviceInfoWarehouse;
            String serviceType = "_grpc._tcp.local.";
            //retrieve service info for each service
            serviceInfoWarehouse = WareHouseServiceDiscovery.runjmDNS(serviceType);

            int warehousePort = serviceInfoWarehouse.getPort();

            ManagedChannel warehouseServiceChannel = ManagedChannelBuilder.forAddress(host, warehousePort)
                    .usePlaintext() //forces ssl to stop (do not use during development
                    .build();

            //WarehouseService
            generateWarehouseReport(warehouseServiceChannel);
            findOrderByOrderNumber(warehouseServiceChannel);
            checkLastOrders(warehouseServiceChannel);

            //do something
            System.out.println("\nShutting down channel");
            warehouseServiceChannel.shutdown();
        }
    }
}
