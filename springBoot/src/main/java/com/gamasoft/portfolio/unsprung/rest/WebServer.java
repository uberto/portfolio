package com.gamasoft.portfolio.unsprung.rest;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebServer {


    public static void start(int port) {
        port(port);

        get("/", (request, response) -> "Greetings from your Portfolio!");

        post("/portfolio", "application/json", PortfolioController::executeOrder);

        get("/portfolio", PortfolioController::handleViewPortfolio);

        post("/ticker", "application/json", TickerController::updatePrices);

        get("/ticker", TickerController::handleViewStockPrice);

    }

}
