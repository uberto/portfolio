package com.gamasoft.portfolio.model;


import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;


@Component
public class StocksPrices extends ConcurrentHashMap<String, Double> {
}
