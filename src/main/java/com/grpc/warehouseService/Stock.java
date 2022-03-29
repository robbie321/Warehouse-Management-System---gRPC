package com.grpc.warehouseService;

public class Stock implements Comparable<Object> {
    private int stockNo;
    private float cost;
    private String productName;
    private int quantity_available;

    // constructor
    public Stock(int stockNo, float cost, String productName, int quantity_available) {
        super();
        this.stockNo=stockNo;
        this.cost = cost;
        this.productName=productName;
        this.quantity_available = quantity_available;
    }

    // setters and getters
    public int getStockNo() {
        return stockNo;
    }

    public void setStockNo(int stockNo) {
        this.stockNo = stockNo;
    }


    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }


    // so the film objects can be compared when sorting/searching
    // NOTE: this will only allow comparisons based on the title of the film
    @Override
    public int compareTo(Object obj) {

		/*
		Edit this section so it compares the appropriate
		column you wish to sort by
		*/

        Stock stk = (Stock)obj;
        return stockNo - (stk.getStockNo());
    }

    @Override
    public String toString() {
        return "Stock [StockNo=" + stockNo+ ", Cost="+ cost+
                ", Product name=" + productName+ "]";
    }
}
