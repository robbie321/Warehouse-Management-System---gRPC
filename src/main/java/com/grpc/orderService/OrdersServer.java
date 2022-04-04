package com.grpc.orderService;


import com.grpc.warehouseService.Stock;
import com.grpc.warehouseService.WarehouseServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Logger;

public class OrdersServer extends orderServiceGrpc.orderServiceImplBase {
    public static Stock[] stock;
    public static void main(String[] args) {
        //set logging
        final Logger logger = Logger.getLogger(OrdersServer.class.getName());

        //create instance of this class
        OrdersServer ordersServer = new OrdersServer();

        //get stock list
        WarehouseServer ws = new WarehouseServer();
        stock = ws.makeDatabase();

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

                //multiply cost of product by quantity to get price
                productSum = value.getProduct().getCost() * value.getQuantity();

                //add product sum to total sum to keep track of total cost
                totalSum += value.getProduct().getCost() * value.getQuantity();

                //add response to item
                item += value.getProduct().getProductName() + "€"+value.getProduct().getCost() + " x " + "€" + value.getQuantity()
                + " = " + productSum + "\n";
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
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

    public void filterPrice(FilterPriceRequest request, StreamObserver<FilterPriceResponse> responseObserver) {
        //users max price
        int maxPrice = request.getMaxPrice();

        //result
        try{
            for(int i = 0; i < stock.length; i++){
                String result = "";
                //if stock price is less than max price
                if(stock[i].getCost() <= maxPrice) {
                    //let reuslt equal to stock listing
                    result = stock[i].getProductName() + " costs: €"+stock[i].getCost();

                    //build response
                    FilterPriceResponse response = FilterPriceResponse.newBuilder()
                            .setProduct(result)
                            .build();

                    //observe next response
                    responseObserver.onNext(response);
                    Thread.sleep(10L);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            responseObserver.onCompleted();
        }
    }

}
