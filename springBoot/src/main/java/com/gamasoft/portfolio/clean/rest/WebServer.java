package com.gamasoft.portfolio.clean.rest;

import com.gamasoft.portfolio.clean.model.Portfolio;
import com.gamasoft.portfolio.clean.model.StocksPrices;

import static spark.Spark.*;

public class WebServer {

    private final TickerController tickerController;
    private final PortfolioController portfolioController;

    public WebServer(StocksPrices stocksPrices, Portfolio portfolio) {
        tickerController = new TickerController(stocksPrices);
        portfolioController = new PortfolioController(portfolio, stocksPrices);
    }

    public void start(int port) {

        port(port);

        get("/", (request, response) -> "Greetings from your Portfolio!");

        post("/portfolio", "application/json", portfolioController::executeOrder);

        get("/portfolio", portfolioController::handleViewPortfolio);

        post("/ticker", "application/json", tickerController::updatePrices);

        get("/ticker", tickerController::handleViewStockPrice);

    }

}
