package com.grpc.warehouseService;

import com.grpc.orderService.OrdersServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.*;
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


        //try catch
        try{
            //initiate a server and await termination
            Server server = ServerBuilder.forPort(port)
                    .addService(warehouseServer)
                    .build()
                    .start();

            server.awaitTermination();
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

        //log
        logger.info(("Server started on port: " + port));

    }

    public Stock[] makeDatabase(){
        Stock[] stocks= new Stock[1000];

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

    @Override
    public void generateReportStream(reportRequest request, StreamObserver<reportResponse> responseObserver) {
        //get data from request
        String from_date = request.getDate();


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
        } finally {
            //call completed by the observer
            responseObserver.onCompleted();
        }
    }

    @Override
    public void reportAnOrder(orderRequest request, StreamObserver<orderResponse> responseObserver) {
        super.reportAnOrder(request, responseObserver);
    }

    @Override
    public void sendShippingInfo(orderRequest request, StreamObserver<shippingResponse> responseObserver) {
        super.sendShippingInfo(request, responseObserver);
    }
}
