package com.gamasoft.portfolio.bigglobals.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamasoft.portfolio.bigglobals.model.BuySellOrder;
import com.gamasoft.portfolio.bigglobals.model.Portfolio;
import spark.Request;
import spark.Response;
import com.gamasoft.portfolio.bigglobals.model.BigGlobals;

import java.io.IOException;

public class PortfolioController {

    private Portfolio portfolio = BigGlobals.get().getPortfolio();

    private static void executeOrder(BuySellOrder order, Portfolio portfolio) {
        portfolio.executeOrder(order);
    }

    private static String getPortfolio(Portfolio portfolio) {
        StringBuilder resp = new StringBuilder( "Your portfolio at the moment is:\n");
        double tot = 0;
        for (String stockName : portfolio.getAllStocks()) {
            resp.append(stockName);
            resp.append("  qty: ");
            resp.append(portfolio.getQuantity(stockName));
            resp.append("  val: ");
            double val = portfolio.getValue(stockName);
            resp.append(val);
            resp.append("\n");
            tot += val;
        }
        resp.append("Total: ");
        resp.append(tot);
        resp.append("\ns");


        return resp.toString();
    }

    public static int executeOrder(Request request, Response response) {

        ObjectMapper objectMapper = new ObjectMapper();

        BuySellOrder order = null;
        try {
            order = objectMapper.readValue(request.body(), BuySellOrder.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        executeOrder(order, BigGlobals.get().getPortfolio());

        return 201;
    }

    public static String handleViewPortfolio(Request request, Response response) {
        return getPortfolio(BigGlobals.get().getPortfolio());
    }
}
