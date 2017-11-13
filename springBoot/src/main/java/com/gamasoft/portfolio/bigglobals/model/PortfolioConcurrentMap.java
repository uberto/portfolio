package com.gamasoft.portfolio.bigglobals.model;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PortfolioConcurrentMap implements Portfolio {

    Map<String, Integer> stocks = new ConcurrentHashMap<String, Integer>();

    private StocksPrices stocksPrices = BigGlobals.get().getStockPrices();

    @Override
    public void executeOrder(BuySellOrder order) {
        stocks.compute(order.getStockName(), (s, q)-> defZero(q) + order.getQuantity() );
    }


    private Integer defZero(Integer q) {
        return q == null ? 0 : q;
    }

    @Override
    public Set<String> getAllStocks() {
        return stocksPrices.keySet();
    }

    @Override
    public int getQuantity(String stockName) {
        return defZero(stocks.get(stockName));
    }

    @Override
    public double getValue(String stockName) {
        return getQuantity(stockName) * stocksPrices.getOrDefault(stockName, 0.0);

    }
}
