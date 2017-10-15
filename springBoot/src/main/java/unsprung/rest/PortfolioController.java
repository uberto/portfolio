package unsprung.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unsprung.model.BigGlobals;
import unsprung.model.BuySellOrder;
import unsprung.model.Portfolio;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    private Portfolio portfolio = BigGlobals.getInstance().getPortfolio();

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
