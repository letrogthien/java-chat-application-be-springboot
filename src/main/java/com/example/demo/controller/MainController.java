package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.MessageData;
import com.example.demo.services.MessageService;
import com.example.demo.socket.ChatService;
import com.example.demo.socket.Message;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MainController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ChatService chatService;

    @Autowired
    private ObjectMapper oMapper;

    @GetMapping("/v1/getmessage")
    public ResponseEntity<?> getMethodName(@RequestParam Integer u1, @RequestParam Integer u2) {
        MessageData messageData = messageService.getByUser1AndUser2(u1, u2).orElse(null);
        MessageData messageData1 = messageService.getByUser1AndUser2(u2, u1).orElse(null);
        if (messageData != null) {
            File file = new File("/tmp/" + messageData.getFilename());
            List<Message> message = new ArrayList<>();
            try {
                message = chatService.readMessagesFromFile(file);
                return new ResponseEntity<>(message, HttpStatus.OK);
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        if (messageData1 != null) {
            File file = new File("/tmp/" + messageData1.getFilename());
            List<Message> message = new ArrayList<>();
            try {
                message = chatService.readMessagesFromFile(file);
                return new ResponseEntity<>(message, HttpStatus.OK);
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
        
    }

    @GetMapping("/v1/seen")
    public ResponseEntity<?> changeSeen(@RequestParam Integer u1, @RequestParam Integer u2) {
        MessageData messageData = messageService.getByUser1AndUser2(u1, u2).orElseThrow();
        File file = new File("/tmp/" + messageData.getFilename());
        List<Message> message = new ArrayList<>();
        try {
            message = chatService.readMessagesFromFile(file);
            for (Message m : message) {
                m.setReadReceipt(true);
            }
            oMapper.writeValue(file, message);
        } catch (IOException e) {

            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
