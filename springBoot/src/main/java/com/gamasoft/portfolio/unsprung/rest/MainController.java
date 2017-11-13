package com.gamasoft.portfolio.unsprung.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @RequestMapping("/")
    public String index() {
        return "Greetings from your Portfolio!";
    }

}
