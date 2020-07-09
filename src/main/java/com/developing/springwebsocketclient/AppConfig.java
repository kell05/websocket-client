package com.developing.springwebsocketclient;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;


@Configuration
public class AppConfig {



    @Bean
    public StandardWebSocketClient getStandardWebSocketClient() {
        return new StandardWebSocketClient();
    }

    @Bean
    public WebSocketConnectionManager getWebSocketConnectionManager(MessagingWebSocketHandler webSocketHandler,
                                                                    StandardWebSocketClient standardWebSocketClient) {
        String url = "ws://localhost:8080/socket";
        return new WebSocketConnectionManager(standardWebSocketClient, webSocketHandler,url);
    }
}