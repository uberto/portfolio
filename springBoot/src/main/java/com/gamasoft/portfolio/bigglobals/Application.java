package com.gamasoft.portfolio.bigglobals;


import com.gamasoft.portfolio.bigglobals.model.ContextMaps;
import com.gamasoft.portfolio.bigglobals.rest.WebServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.gamasoft.portfolio.bigglobals.model.BigGlobals;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

    //If you uncomment the following line and comment the WebServer.start than it will work using SpringBoot.
    //    SpringApplication.run(Application.class, args);


        BigGlobals.init(new ContextMaps());
        WebServer.start(8080);
    }


}
