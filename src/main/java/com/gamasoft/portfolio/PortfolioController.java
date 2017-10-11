package com.gamasoft.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private StocksPrices stocksPrices;

    @Autowired
    private Portfolio portfolio;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> executeOrder(@RequestBody BuySellOrder order) {

        portfolio.compute(order.getStockName(), (s, q)-> defZero(q) + order.getQuantity() );
        return ResponseEntity.accepted().build();
    }

    private Integer defZero(Integer q) {
        return q == null ? 0 : q;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getValue() {
        StringBuilder resp = new StringBuilder( "Your portfolio at the moment is:\n");
        double tot = 0;
        for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
            resp.append(entry.getKey());
            resp.append("  qty: ");
            resp.append(entry.getValue());
            resp.append("  val: ");
            double val = entry.getValue() * stocksPrices.getOrDefault(entry.getKey(), 0.0);
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
