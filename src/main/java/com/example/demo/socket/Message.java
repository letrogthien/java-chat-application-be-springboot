package com.example.demo.socket;

import java.util.Date;

import lombok.Data;

@Data
public class Message {
    
    private Integer senderId;
    private Integer recipientId;
    private Date timestamp;
    private String content;
    private Messagetype messageType;
    private boolean readReceipt;
    private String chatId;
    private String status;
}

