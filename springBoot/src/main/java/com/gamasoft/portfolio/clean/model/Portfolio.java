package com.gamasoft.portfolio.clean.model;

import java.util.Set;
import java.util.function.Function;

public interface Portfolio {
    void executeOrder(BuySellOrder order);

    Set<String> getAllStocks();

    int getQuantity(String stockName);

    Function<StocksPrices, Double> getValue(String stockName);
}
