package com.grpc.stockCheckerService;

import com.grpc.orderService.product;
import io.grpc.stub.StreamObserver;

public class inventoryCheckerServiceImpl extends inventoryCheckerServiceGrpc.inventoryCheckerServiceImplBase{

    @Override
    public void addProductsToStock(addStockRequest request, StreamObserver<addStockResponse> responseObserver) {
        //get product details and assign to data type
        String title = request.getProductName();
        int quantityAvailable = request.getQuantityAvailable();

        //append details to file
    }

    @Override
    public void updateProductInfo(product request, StreamObserver<product> responseObserver) {
        //delete old product & add the updated one
        String newTitle = request.getProductName();
        int quantityAvailable = request.getQuantityAvailable();

        //append details to file


    }

    @Override
    public void checkLowStock(lowStockRequest request, StreamObserver<lowStockResponse> responseObserver) {

        //check the number entered against stock that has less than the request number
        int threshold = request.getQuantity();

        //if a product has less than threshold, display product

    }
}
