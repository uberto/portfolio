package com.gamasoft.portfolio.bigglobals.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class MainController {


    public String index() {
        return "Greetings from your Portfolio!";
    }

}
