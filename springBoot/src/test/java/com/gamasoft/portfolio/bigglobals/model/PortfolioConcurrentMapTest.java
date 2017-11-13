package com.gamasoft.portfolio.bigglobals.model;

import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class PortfolioConcurrentMapTest {

    @Test
    public void executeAnOrder() throws Exception {

        String vod = "VOD.L";
        Context ctx = new ContextMaps();
        ctx.getStockPrices().put(vod, 123.4);
        BigGlobals.init(ctx);

        Portfolio p = new PortfolioConcurrentMap();

        assertThat(p.getQuantity(vod)).isEqualTo(0);
        assertThat(p.getValue(vod)).isEqualTo(0);

        BuySellOrder order = new BuySellOrder(vod, 110);
        p.executeOrder(order);

        assertThat(p.getQuantity(vod)).isEqualTo(110);
        assertThat(p.getValue(vod)).isEqualTo(13574);
    }
}