package com.gamasoft.portfolio.unsprung.model;

public class ContextMaps implements Context {

    private static Context instance =  new ContextMaps();

    private Portfolio portfolio = null;
    private StocksPrices stockPrices = null;

    @Override
    synchronized public Portfolio getPortfolio() {
        if (portfolio == null)
            portfolio = new PortfolioConcurrentMap();
        return portfolio;
    }

    @Override
    synchronized public StocksPrices getStockPrices() {
        if (stockPrices == null)
            stockPrices = new StocksPrices();
        return stockPrices;
    }


}
