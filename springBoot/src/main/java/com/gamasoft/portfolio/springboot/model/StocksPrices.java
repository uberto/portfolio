package com.gamasoft.portfolio.springboot.model;


import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;


@Component
public class StocksPrices extends ConcurrentHashMap<String, StockPrice> {

    private static final StockPrice emptyStockPrice = new StockPrice("", 0.0);


    public double getPrice(String stockName) {
        return getOrDefault(stockName, emptyStockPrice).getStockPrice();
    }
}
