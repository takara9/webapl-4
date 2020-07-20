package com.example.servingwebcontent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ServingWebContentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context
	    = SpringApplication.run(ServingWebContentApplication.class, args);
    }
}
