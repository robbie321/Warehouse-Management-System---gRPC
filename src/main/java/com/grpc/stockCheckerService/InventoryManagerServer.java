package com.grpc.stockCheckerService;

import com.grpc.orderService.OrdersServer;
import com.grpc.orderService.product;
import com.grpc.warehouseService.Stock;
import com.grpc.warehouseService.WarehouseServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class InventoryManagerServer extends inventoryCheckerServiceGrpc.inventoryCheckerServiceImplBase{
    public static Stock[] stock;
    public static void main(String[] args) {
//set logging
        final Logger logger = Logger.getLogger(OrdersServer.class.getName());
        //create instance of this class
        InventoryManagerServer inventoryManagerServer = new InventoryManagerServer();

        //get stock list
        WarehouseServer ws = new WarehouseServer();
        stock = ws.makeDatabase();

        //make available channel
        int port = 50053;

        //try catch
        try{
            //initiate a server and await termination
            Server server = ServerBuilder.forPort(port)
                    .addService(inventoryManagerServer)
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
    public void addProductsToStock(addStockRequest request, StreamObserver<addStockResponse> responseObserver) {

        //get user data
        String productName = request.getProductName();
        float cost = request.getCost();
        int quantity = request.getQuantityAvailable();

        //last stock number + 1
        int stock_no = stock[stock.length - 1].getStockNo() + 1;

        try{
            //write to a file
            File directory = new File("src/main/java/com/grpc");
            String name = directory.getAbsolutePath() + "//stock.csv";

            //convert stock num to string
            String stockNo = String.valueOf(stock_no);

            //initialise bufferedWriter
            BufferedWriter writer = new BufferedWriter(new FileWriter(name, true));

            //append to end of file
            writer.append("\n"+stockNo + ","+ cost + "," +productName.toLowerCase() + "," + quantity);

            //close the writer
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        addStockResponse response = addStockResponse.newBuilder()
                .setMessage("New item added to stock \n" +
                        "Product Name: " + productName + "\nCost: " + cost +
                         "\nQuantity in stock: " + quantity)
                        .build();

        //call onNext by the observer
        responseObserver.onNext(response);

        //call completed by the observer
        responseObserver.onCompleted();
    }

    @Override
    public void updateProductInfo(product request, StreamObserver<product> responseObserver) {
        super.updateProductInfo(request, responseObserver);
    }

    @Override
    public void checkLowStock(lowStockRequest request, StreamObserver<lowStockResponse> responseObserver) {
        //quantity to check levels
        int stockLevelToCheck = request.getQuantity();

        //result
        try{
            for(int i = 0; i < stock.length; i++){
                String result = "";
                //if stock price is less than max price
                if(stock[i].getQuantity_available() <= stockLevelToCheck) {

                    //let result equal to stock listing
                    result ="Product: " + stock[i].getProductName() + " ,Stock remaining: "+stock[i].getQuantity_available();

                    //build response
                    lowStockResponse response = lowStockResponse.newBuilder()
                            .setMessage(result)
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
