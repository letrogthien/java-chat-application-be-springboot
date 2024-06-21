package com.example.demo.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.models.User;
import com.example.demo.services.UserService;

@Component
public class WebSocketEventsListener {
    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventsListener.class);

    // @EventListener
    // public void handleSessionConnected(SessionConnectedEvent event) {
    //     StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
    //     Map<String, Object> attributes = headerAccessor.getSessionAttributes();
        
    //     if (attributes != null) {
    //         String userId = (String) attributes.get("userId");
    //         if (userId != null && !userId.isEmpty()) {
    //             logger.info("Received connection from userId: {}", userId);
                
    //             try {
    //                 Integer userIdInt = Integer.parseInt(userId);
    //                 userService.setStatusOnline(userIdInt);
    //             } catch (NumberFormatException e) {
    //                 logger.error("Error parsing userId to Integer: {}", userId, e);
    //             }
    //         }
    //     } else {
    //         logger.warn("No attributes found in session connected event!");
    //     }
    // }
       

    @EventListener
    public void handleSessionDisconnect(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        Map<String, Object> attributes = headerAccessor.getSessionAttributes();
        
        if (attributes != null) {
            String userId = (String) attributes.get("userId");
            if (userId != null && !userId.isEmpty()) {
                logger.info("Received connection from userId: {}", userId);
                
                try {
                    Integer userIdInt = Integer.parseInt(userId);
                    userService.setStatusOff(userIdInt);
                } catch (NumberFormatException e) {
                    logger.error("Error parsing userId to Integer: {}", userId, e);
                }
            }
        } else {
            logger.warn("No attributes found in session connected event!");
        }
    }
}