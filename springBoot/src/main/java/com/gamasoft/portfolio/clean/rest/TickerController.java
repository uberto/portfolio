package com.gamasoft.portfolio.clean.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamasoft.portfolio.clean.model.StockPrice;
import com.gamasoft.portfolio.clean.model.StocksPrices;
import spark.Request;
import spark.Response;

import java.io.IOException;

public class TickerController {

    private final StocksPrices stocksPrices;

    public TickerController(StocksPrices stocksPrices) {
        this.stocksPrices = stocksPrices;
    }

    private String getStockPrice(String stock) {
        return "The price for " + stock + " is " + stocksPrices.getPrice(stock) + "\n";
    }

    private void setStockPrices(StockPrice[] newPrices) {
        for (StockPrice price : newPrices) {

            stocksPrices.put(price.getStockName(), price);
        }
    }

    public String updatePrices(Request request, Response response) {

        ObjectMapper objectMapper = new ObjectMapper();

        StockPrice[] prices = null;
        try {
            prices = objectMapper.readValue(request.body(), StockPrice[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setStockPrices(prices);

        response.status(201);
        return "Updated";
    }

    public String handleViewStockPrice(Request request, Response responses) {

        String stock = request.queryParamOrDefault("stock", "");
        return getStockPrice(stock);
    }
}
