package com.gamasoft.portfolio.springboot.model;

import java.util.Set;

public interface Portfolio {
    void executeOrder(BuySellOrder order);

    Set<String> getAllStocks();

    int getQuantity(String stockName);

    double getValue(String stockName);
}
