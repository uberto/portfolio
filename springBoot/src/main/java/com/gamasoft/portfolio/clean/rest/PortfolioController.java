package com.gamasoft.portfolio.clean.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamasoft.portfolio.clean.model.BuySellOrder;
import com.gamasoft.portfolio.clean.model.Portfolio;
import com.gamasoft.portfolio.clean.model.StocksPrices;
import spark.Request;
import spark.Response;

import java.io.IOException;

public class PortfolioController {

    private final Portfolio portfolio;
    private final StocksPrices stocksPrices;

    public PortfolioController(Portfolio portfolio, StocksPrices stocksPrices) {
        this.portfolio = portfolio;
        this.stocksPrices = stocksPrices;
    }

    private void executeOrder(BuySellOrder order) {
        portfolio.executeOrder(order);
    }

    private String getPortfolio() {
        StringBuilder resp = new StringBuilder( "Your portfolio at the moment is:\n");
        double tot = 0;
        for (String stockName : portfolio.getAllStocks()) {
            resp.append(stockName);
            resp.append("  qty: ");
            resp.append(portfolio.getQuantity(stockName));
            resp.append("  val: ");
            double val = portfolio.getValue(stockName).apply(stocksPrices);
            resp.append(val);
            resp.append("\n");
            tot += val;
        }
        resp.append("Total: ");
        resp.append(tot);
        resp.append("\ns");


        return resp.toString();
    }

    public String executeOrder(Request request, Response response) {

        ObjectMapper objectMapper = new ObjectMapper();

        BuySellOrder order = null;
        try {
            order = objectMapper.readValue(request.body(), BuySellOrder.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        executeOrder(order);

        response.status(201);
        return "executed!";
    }

    public String handleViewPortfolio(Request request, Response response) {
        return getPortfolio();
    }
}
