package com.grpc.orderService;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class OrdersServer extends orderServiceGrpc.orderServiceImplBase {
    public static void main(String[] args) {
        //set logging
        final Logger logger = Logger.getLogger(OrdersServer.class.getName());

        //create instance of this class
        OrdersServer ordersServer = new OrdersServer();

        //make a channel available for communication
        int port = 50051;

        //try catch
        try{
            //initiate a server and await termination
            Server server = ServerBuilder.forPort(port)
                    .addService(ordersServer)
                    .build()
                    .start();
            server.awaitTermination();
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

        //log
        logger.info(("Server started on port: " + port));

    }

    @Override
    public void createOrder(orderRequest request, StreamObserver<orderResponse> responseObserver) {
        System.out.println("Receiving order request");

        //get data from request
        String item = request.getItem();
        int quantity = request.getQuantity();

        //wite to a file

        //create the response
        orderResponse response = orderResponse.newBuilder()
                .setMessage("Your order has been confirmed" +
                        " \n Item: " + item + " \n Quantity: "+quantity)
                .build();

        //call onNext by the observer
        responseObserver.onNext(response);

        //call completed by the observer
        responseObserver.onCompleted();

    }

//    @Override
//    public void generateReportStream(reportRequest request, StreamObserver<reportResponse> responseObserver) {
//
//        //get data from request
//        String from_date = request.getDateOne();
//        String to_date = request.getDateTwo();
//
//
//        //add each row to result
//        String result = "Report generated from \" + from_date + \" to \" + to_date";
//
//        //set file path
//        String file = "src/main/java/com/grpc/mock_data.csv";
//        String line = "";
//
//        try{
//            //read file
//            BufferedReader br = new BufferedReader(new FileReader(file));
//
//            //loop until the next line is null
//            while((line = br.readLine()) != null){
//                //split the columns by comma
//                String[] sales = line.split(",");
//                //add row to array if matches condition
//                if(sales[0].contains(from_date) || sales[0].contains(to_date))
//                    result += "\nProduct: " + sales[1] + ", Sold: " + sales[2];
//                else
//                    result = "There were no products sold on or between " + from_date + " and " + to_date;
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //create the response
//        reportResponse response = reportResponse.newBuilder()
//                .setMessage(result)
//                .build();
//
//        //call onNext by the observer
//        responseObserver.onNext(response);
//
//        //call completed by the observer
//        responseObserver.onCompleted();
//    }
}
