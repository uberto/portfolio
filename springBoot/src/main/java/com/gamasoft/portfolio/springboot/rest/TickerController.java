package com.gamasoft.portfolio.springboot.rest;

import com.gamasoft.portfolio.springboot.model.StockPrice;
import com.gamasoft.portfolio.springboot.model.StocksPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ticker")
public class TickerController {

    @Autowired
    private StocksPrices stocksPrices;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> setStockPrice(@RequestBody StockPrice[] newPrices) {

        for (StockPrice price : newPrices) {

            stocksPrices.put(price.getStockName(), price);
        }

        return ResponseEntity.accepted().build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getStockPrice(@RequestParam(value="stock") String stock) {
        return "The price for " + stock + " is " + stocksPrices.getPrice(stock) + "\n";
    }
}
