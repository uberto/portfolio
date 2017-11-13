package com.gamasoft.portfolio.bigglobals.model;


import java.util.concurrent.ConcurrentHashMap;


public class StocksPrices extends ConcurrentHashMap<String, StockPrice> {

    private static final StockPrice emptyStockPrice = new StockPrice("", 0.0);

    public double getPrice(String stockName) {
        return getOrDefault(stockName, emptyStockPrice).getStockPrice();
    }
}
