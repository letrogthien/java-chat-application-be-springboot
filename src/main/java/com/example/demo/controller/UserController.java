package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    
    
    @GetMapping("/v1/user")
    public ResponseEntity<?> getUserById(@RequestParam Integer id) {
        User user = userService.getUserById(id).orElse(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
}
