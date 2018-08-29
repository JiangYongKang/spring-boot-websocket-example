package com.vincent.websocket.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WebsocketExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketExampleApplication.class, args);
    }
}
