package com.developing.springwebsocketclient;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;


@Service
public class MessagingWebSocketHandler extends TextWebSocketHandler {

    private static final Logger log = LogManager.getLogger(MessagingWebSocketHandler.class);

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        log.info("Received message: " +  message.getPayload());
        session.sendMessage(new TextMessage("FOOBAR"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws IOException {
        log.info("Connection established");
        session.sendMessage(new TextMessage("Hello"));
        log.info("Subscription payload sent: " + "Hello");
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        log.error("Transport error");
        exception.printStackTrace();
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        log.info("Closed connection: " + status.getReason());
    }

}