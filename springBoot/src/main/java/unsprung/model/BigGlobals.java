package unsprung.model;

public class BigGlobals {

    private static BigGlobals instance = null;

    private Portfolio portfolio = null;
    private StocksPrices stockPrices = null;

    synchronized public Portfolio getPortfolio() {
        if (portfolio == null)
            portfolio = new PortfolioConcurrentMap();
        return portfolio;
    }

    synchronized public StocksPrices getStockPrices() {
        if (stockPrices == null)
            stockPrices = new StocksPrices();
        return stockPrices;
    }

    public static BigGlobals getInstance() {
        if (instance == null)
            instance = new BigGlobals();
        return instance;
    }
}
