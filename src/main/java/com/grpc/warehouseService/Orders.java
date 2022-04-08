package com.grpc.warehouseService;

public class Orders {
    int orderNumber;
    String product;
    int quantity;

    Orders(int orderNumber, String product, int quantity){
        this.orderNumber = orderNumber;
        this.product = product;
        this.quantity = quantity;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order#: " + orderNumber+ ", Product: "+ product+
                ", Quantity: " + quantity;
    }
}
