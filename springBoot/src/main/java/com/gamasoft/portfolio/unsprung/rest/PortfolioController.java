package com.gamasoft.portfolio.unsprung.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamasoft.portfolio.unsprung.model.BuySellOrder;
import com.gamasoft.portfolio.unsprung.model.Portfolio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spark.Request;
import spark.Response;
import com.gamasoft.portfolio.unsprung.model.BigGlobals;

import java.io.IOException;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    private Portfolio portfolio = BigGlobals.get().getPortfolio();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> executeOrder(@RequestBody BuySellOrder order) {

        executeOrder(order, portfolio);
        return ResponseEntity.accepted().build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getPortolio() {
        return getPortfolio(portfolio);
    }


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
