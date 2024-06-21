package com.example.demo.socket;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.models.MessageData;
import com.example.demo.services.MessageService;
import com.example.demo.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private ObjectMapper oMapper;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private ChatService chatService;

    @MessageMapping("/private-message")
    public Message recMessage(@Payload Message message) {
        logger.info("Received message: {}", message);
        simpMessagingTemplate.convertAndSendToUser(message.getRecipientId().toString(), "/private", message);
        logger.info("Sent message to user {}: {}", message.getRecipientId(), message);
        
        try {
            if (message.getMessageType().toString().equals("TEXT")) {
                MessageData message2 = messageService
                        .getByUser1AndUser2(message.getSenderId(), message.getRecipientId()).orElse(null);
                MessageData message3 = messageService
                        .getByUser1AndUser2(message.getRecipientId(), message.getSenderId()).orElse(null);
                if (message2 != null) {
                    File jsonFile = new File("/tmp/" + message2.getFilename());
                    List<Message> messages = chatService.readMessagesFromFile(jsonFile);
                    messages.add(message);
                    oMapper.writeValue(jsonFile, messages);
                    logger.info("Updated message file for user {}: {}", message.getSenderId(), message2.getFilename());
                }
                if (message3 != null) {
                    File jsonFile = new File("/tmp/" + message3.getFilename());
                    List<Message> messages = chatService.readMessagesFromFile(jsonFile);
                    messages.add(message);
                    oMapper.writeValue(jsonFile, messages);
                    logger.info("Updated message file for user {}: {}", message.getRecipientId(), message3.getFilename());
                }

                if (message2 == null && message3 == null) {
                    MessageData newMessageData = new MessageData();
                    String filename = message.getSenderId().toString() + "_" + message.getRecipientId().toString()
                            + ".json";
                    File jsonFile = chatService.createFileIfNotExists("/tmp/" + filename);
                    List<Message> messages = new ArrayList<>();
                    messages.add(message);
                    oMapper.writeValue(jsonFile, messages);
                    newMessageData.setUser1(
                            userService.getUserById(message.getSenderId()).orElseThrow());
                    newMessageData.setUser2(
                            userService.getUserById(message.getRecipientId()).orElseThrow());
                    newMessageData.setFilename(filename);

                    messageService.saveMessage(newMessageData);
                    logger.info("Created new message file: {}", filename);
                }
            }

        } catch (Exception e) {
            logger.error("Error processing message: {}", e.getMessage(), e);
        }

        return message;
    }
}