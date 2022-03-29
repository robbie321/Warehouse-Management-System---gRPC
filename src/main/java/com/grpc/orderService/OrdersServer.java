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

    @Override
    public StreamObserver<StockQuoteRequest> streamStockQuote(StreamObserver<StockQuoteResponse> responseObserver) {



        //create stream observer
        StreamObserver<StockQuoteRequest> requestStreamObserver = new StreamObserver<StockQuoteRequest>() {
            //product passed from client
            String item = "";

            //calculate total sum of all products
            float totalSum = 0;

            //calculate sum of the quantity of a single product
            float productSum = 0;

            @Override
            public void onNext(StockQuoteRequest value) {

                //client sends a message
                productSum = value.getProduct().getCost() * value.getQuantity();
                totalSum += value.getProduct().getCost() * value.getQuantity();
                item += value.getProduct().getProductName() + "€"+value.getProduct().getCost() + " x " + value.getQuantity()
                + " = " + productSum + "\n";
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

                responseObserver.onNext(
                        StockQuoteResponse.newBuilder()
                                .setMessage(item)
                                .setPrice(totalSum)
                                .build()
                );

                responseObserver.onCompleted();
            }
        };

        return  requestStreamObserver;
    }

    @Override
    public void filterPrice(filterPriceRequest request, StreamObserver<filterPriceResponse> responseObserver) {
        super.filterPrice(request, responseObserver);

        //user sends max price, server finds all objects for less or equal to the price and displays
    }
}
