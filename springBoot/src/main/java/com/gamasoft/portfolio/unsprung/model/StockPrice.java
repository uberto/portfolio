package com.gamasoft.portfolio.unsprung.model;



public class StockPrice {
    private String stockName;
    private double stockPrice;

    public StockPrice(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
    }

    public StockPrice() {
    }

    public String getStockName() {
        return stockName;
    }

    public double getStockPrice() {
        return stockPrice;
    }
}
