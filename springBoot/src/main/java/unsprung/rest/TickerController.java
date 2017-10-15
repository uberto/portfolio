package unsprung.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unsprung.model.BigGlobals;
import unsprung.model.StockPrice;
import unsprung.model.StocksPrices;

@RestController
@RequestMapping("/ticker")
public class TickerController {

    private StocksPrices stocksPrices = BigGlobals.getInstance().getStockPrices();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> setStockPrice(@RequestBody StockPrice[] newPrices) {

        for (StockPrice price : newPrices) {

            stocksPrices.put(price.getStockName(), price.getStockPrice());
        }

        return ResponseEntity.accepted().build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getStockPrice(@RequestParam(value="stock") String stock) {
        return "The price for " + stock + " is " + stocksPrices.getOrDefault(stock, 0.0) + "\n";
    }
}
