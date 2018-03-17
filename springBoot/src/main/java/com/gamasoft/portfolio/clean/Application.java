package com.gamasoft.portfolio.clean;


import com.gamasoft.portfolio.clean.model.Portfolio;
import com.gamasoft.portfolio.clean.model.PortfolioConcurrentMap;
import com.gamasoft.portfolio.clean.model.StocksPrices;
import com.gamasoft.portfolio.clean.rest.WebServer;

public class Application {


    public static void main(String[] args) {

        // I can put StockPrices and Portfolio inside each requests
        // or I can pass in the Webserver constructor
        // or I can use a global map (service locator)
        StocksPrices stocksPrices = new StocksPrices();
        Portfolio portfolio = new PortfolioConcurrentMap();

        WebServer ws = new WebServer(stocksPrices, portfolio);

        ws.start(8080);
    }


}
