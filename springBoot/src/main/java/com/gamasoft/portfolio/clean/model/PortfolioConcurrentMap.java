package com.gamasoft.portfolio.clean.model;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class PortfolioConcurrentMap implements Portfolio {

    Map<String, Integer> stocks = new ConcurrentHashMap<String, Integer>();

    public PortfolioConcurrentMap(){
    }

    @Override
    public void executeOrder(BuySellOrder order) {
        stocks.compute(order.getStockName(), (s, q)-> defZero(q) + order.getQuantity() );
    }


    private Integer defZero(Integer q) {
        return q == null ? 0 : q;
    }

    @Override
    public Set<String> getAllStocks() {
        return stocks.keySet();
    }

    @Override
    public int getQuantity(String stockName) {
        return defZero(stocks.get(stockName));
    }

    @Override
    public Function<StocksPrices, Double> getValue(String stockName) {
        return stocksPrices -> getQuantity(stockName) * stocksPrices.getPrice(stockName);

    }
}
