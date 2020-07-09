package com.developing.springwebsocketclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.client.WebSocketConnectionManager;

@SpringBootApplication
public class SpringWebsocketClientApplication implements CommandLineRunner {

    private WebSocketConnectionManager messagingWebSocketHandler;

    public SpringWebsocketClientApplication(WebSocketConnectionManager messagingWebSocketHandler){
        this.messagingWebSocketHandler = messagingWebSocketHandler;
    }

    @Override
    public void run(String... args) throws Exception {
        this.messagingWebSocketHandler.start();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringWebsocketClientApplication.class, args);
    }

}
