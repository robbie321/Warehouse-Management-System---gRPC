package com.grpc.warehouseService;

import com.grpc.orderService.OrdersServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;


public class WarehouseServer extends warehouseServiceGrpc.warehouseServiceImplBase {

    public static void main(String[] args) throws IOException {

        //set logging
        final Logger logger = Logger.getLogger(WarehouseServer.class.getName());

        //create instance of this class
        WarehouseServer warehouseServer = new WarehouseServer();

        //make a channel available for communication
        int port = 50052;
        String serviceType= "_grpc._tcp.local.";
        String serviceName = "Warehouse Server";
        String serviceDescription = "Warehouse Server Service";
        WareHouseServerRegistration wsr = new WareHouseServerRegistration();
        wsr.register(port,serviceType,serviceName,serviceDescription);


        //try catch
        try{
            //initiate a server and await termination
            Server server = ServerBuilder.forPort(port)
                    .addService(warehouseServer)
                    .build()
                    .start();

            System.out.println("Warehouse Server is now running...");

            server.awaitTermination();
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

        //log
        logger.info(("Server started on port: " + port));

    }

    public Stock[] makeDatabase() throws FileNotFoundException {

        int count = -1;
        String row;


        //parsing and reading the CSV file data into the film (object) array
        // provide the path here...
        File directory = new File("src/main/java/com/grpc");
        String name = directory.getAbsolutePath() + "//stock.csv";
        Scanner sc = null;
        try {
            sc = new Scanner(new File(name));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //use this to count rows in file before parsing
        //needed for when new lines are added
        BufferedReader reader = new BufferedReader(new FileReader(name));

        while (true) {
            try {
                if (!((row = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            count++;
        }

        Stock[] stocks= new Stock[count];

        // this will just print the header in CSV file
        sc.nextLine();

        int i = 0; String st = "";
        while (sc.hasNextLine())  //returns a boolean value
        {
            st = sc.nextLine();
            String[] data = st.split(",");
            stocks[i++] = new Stock(Integer.parseInt(data[0]),  Float.parseFloat(data[1]), data[2], Integer.parseInt(data[3]));
        }
        sc.close();  //closes the scanner

        return stocks;
    }

    public Orders[] parseFile() {
        // parsing and reading the CSV file data into the film (object) array
        // provide the path here...

        int count = -1;
        String row;

        //parsing and reading the CSV file data into the film (object) array
        // provide the path here...
        File directory = new File("src/main/java/com/grpc");
        String file = directory.getAbsolutePath() + "//orders.csv";

        //use this to count rows in file before parsing
        //needed for when new lines are added

            //read file
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //count number of lines in file
            while (true) {
                try {
                    if (!((row = reader.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                count++;
            }

        Scanner sc = null;
        try {
            sc = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Orders[] orders = new Orders[count];

            sc.nextLine();

            int i = 0;
            String st = "";
            while (sc.hasNextLine()) // returns a boolean value
            {
                st = sc.nextLine();
                String[] data = st.split(",");
                orders[i++] = new Orders(Integer.parseInt(data[0]), data[1].toLowerCase(), Integer.parseInt(data[2]));
            }

            return orders;
    }

    @Override
    public void generateReportStream(reportRequest request, StreamObserver<reportResponse> responseObserver) {
        //get data from request
        String from_date = request.getDate();

        String dateRegex = "^\\d{2}/\\d{2}/\\d{4}$";


        validateDate(dateRegex,from_date);

        //add each row to result
        String result = "";

        //set file path
        String file = "src/main/java/com/grpc/mock_data.csv";
        String line = "";

        try{
            //read file
            BufferedReader br = new BufferedReader(new FileReader(file));

            //loop until the next line is null
            while((line = br.readLine()) != null){
                //split the columns by comma
                String[] sales = line.split(",");
                //add row to array if matches condition
                if(sales[0].contains(from_date)){
                    result = "\nProduct: " + sales[1] + ", Sold: " + sales[2] + " on " + sales[0];

                    //create the response
                    reportResponse response = reportResponse.newBuilder()
                            .setMessage(result)
                            .build();

                    //call onNext by the observer
                    responseObserver.onNext(response);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (InputMismatchException e){
            e.getLocalizedMessage();
        }finally {
            //call completed by the observer
            responseObserver.onCompleted();
        }
    }

    //validate, custom error (Question 2.3)
    private void validateDate(String regex, String string) {
        //throw error if condition is met
        if(!string.matches(regex))
            throw new InputMismatchException(string + " does not match the format dd/mm/yyyy");
    }

    @Override
    public void reportAnOrder(orderNumberRequest request, StreamObserver<orderNumberResponse> responseObserver) {
        //get order number from user
        String orderNumber = request.getOrderNumber();

        //add each row to result
        String result = "";

        //set file path
        String file = "src/main/java/com/grpc/orders.csv";
        String line = "";

        try{
            //read file
            BufferedReader br = new BufferedReader(new FileReader(file));

            //loop until the next line is null
            while((line = br.readLine()) != null){
                //split the columns by comma
                String[] orders = line.split(",");
                System.out.println(orders[0]);
                //add row to array if matches condition
                if(orders[0].equals(orderNumber)){
                    result ="Order# " + orders[0]+  "\nProduct: " + orders[1] + ", Quantity: " + orders[2];
                    break; //stop the loop if found as stockNo is unique
                }else
                    result = "There is no record of this order: " + orderNumber;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //create the response
        orderNumberResponse response = orderNumberResponse.newBuilder()
                .setOrder(result)
                .build();

        //call onNext by the observer
        responseObserver.onNext(response);

        //call completed by the observer
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<lastOrdersRequest> checkLastOrders(StreamObserver<lastOrdersResponse> responseObserver) {


        StreamObserver<lastOrdersRequest> requestObserver = new StreamObserver<lastOrdersRequest>() {
            @Override
            public void onNext(lastOrdersRequest value) {
                String result = "Product: " + value.getProduct().getProductName()
                        + "\nCost: " + value.getProduct().getCost()
                        +"\nStock available: " + value.getProduct().getQuantityAvailable() +"\n";

                lastOrdersResponse response = lastOrdersResponse.newBuilder()
                        .setProducts(result)
                        .build();

                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                t.getMessage();
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };

        return requestObserver;
    }
}
