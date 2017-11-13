package com.gamasoft.portfolio.bigglobals.model;

import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class PortfolioConcurrentMapTest {

    @Test
    public void executeAnOrder() throws Exception {

        StockPrice vod = new StockPrice("VOD.L", 123.4);
        Context ctx = new ContextMaps();
        ctx.getStockPrices().put(vod.getStockName(), vod);
        BigGlobals.init(ctx);

        Portfolio p = new PortfolioConcurrentMap();

        assertThat(p.getQuantity(vod.getStockName())).isEqualTo(0);
        assertThat(p.getValue(vod.getStockName())).isEqualTo(0);

        BuySellOrder order = new BuySellOrder(vod.getStockName(), 110);
        p.executeOrder(order);

        assertThat(p.getQuantity(vod.getStockName())).isEqualTo(110);
        assertThat(p.getValue(vod.getStockName())).isEqualTo(13574);
    }
}