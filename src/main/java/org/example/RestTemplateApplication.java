package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RestTemplateApplication {

    @Autowired
    MainApplicationRunner mainApplicationRunner;

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class, args);
    }

    // po uruchomieniu aplikacji zostają wywoływane poniższe metody
    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        mainApplicationRunner.start();
    }
}