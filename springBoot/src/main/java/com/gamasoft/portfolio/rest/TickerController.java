package com.gamasoft.portfolio.rest;

import com.gamasoft.portfolio.model.StockPrice;
import com.gamasoft.portfolio.model.StocksPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticker")
public class TickerController {

    @Autowired
    private StocksPrices stocksPrices;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> setStockPrice(@RequestBody StockPrice stockPrice) {

        stocksPrices.put(stockPrice.getStockName(), stockPrice.getStockPrice());

        return ResponseEntity.accepted().build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getStockPrice(@RequestParam(value="stock") String stock) {
        return "The price for " + stock + " is " + stocksPrices.getOrDefault(stock, 0.0) + "\n";
    }
}
