package com.gamasoft.portfolio.unsprung.model;

public class BuySellOrder {
    private String stockName;
    private Integer quantity; //negatives means sell

    public BuySellOrder() {
    }

    public BuySellOrder(String stock, Integer quantity) {
        this.stockName = stock;
        this.quantity = quantity;
    }

    public String getStockName() {
        return stockName;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
