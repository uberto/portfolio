package com.gamasoft.portfolio;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class Portfolio extends ConcurrentHashMap<String, Integer>{
}