package unsprung;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import unsprung.model.BigGlobals;
import unsprung.model.ContextMaps;
import unsprung.rest.WebServer;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

    //If you uncomment the following line and comment the WebServer.start than it will work using SpringBoot.
    //    SpringApplication.run(Application.class, args);


        BigGlobals.init(new ContextMaps());
        WebServer.start(8080);
    }


}
