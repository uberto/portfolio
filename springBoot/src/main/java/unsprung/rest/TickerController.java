package unsprung.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spark.Request;
import spark.Response;
import unsprung.model.*;

import java.io.IOException;

@RestController
@RequestMapping("/ticker")
public class TickerController {

    private StocksPrices stocksPrices = BigGlobals.get().getStockPrices();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> setStockPrice(@RequestBody StockPrice[] newPrices) {

        setStockPrices(newPrices, stocksPrices);

        return ResponseEntity.accepted().build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getStockPrice(@RequestParam(value="stock") String stock) {
        return getStockPrice(stock, stocksPrices);
    }

    private static String getStockPrice(String stock, StocksPrices stocksPrices) {
        return "The price for " + stock + " is " + stocksPrices.getOrDefault(stock, 0.0) + "\n";
    }

    private static void setStockPrices(StockPrice[] newPrices, StocksPrices stocksPrices) {
        for (StockPrice price : newPrices) {

            stocksPrices.put(price.getStockName(), price.getStockPrice());
        }
    }

    public static int updatePrices(Request request, Response response) {

        ObjectMapper objectMapper = new ObjectMapper();

        StockPrice[] prices = null;
        try {
            prices = objectMapper.readValue(request.body(), StockPrice[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setStockPrices(prices, BigGlobals.get().getStockPrices());

        return 201;
    }

    public static String handleViewStockPrice(Request request, Response response) {


        String stock = request.queryParamOrDefault("stock", "");
        return getStockPrice(stock, BigGlobals.get().getStockPrices());
    }
}
