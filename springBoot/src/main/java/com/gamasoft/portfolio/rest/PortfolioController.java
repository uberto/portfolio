package com.gamasoft.portfolio.rest;

import com.gamasoft.portfolio.model.BuySellOrder;
import com.gamasoft.portfolio.model.Portfolio;
import com.gamasoft.portfolio.model.PortfolioConcurrentMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private Portfolio portfolio;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> executeOrder(@RequestBody BuySellOrder order) {

        portfolio.executeOrder(order);
        return ResponseEntity.accepted().build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getPortolio() {
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
}
