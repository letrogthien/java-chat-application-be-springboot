package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.socket.UserStatus;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public void setStatusOnline(Integer id) {
        User user = getUserById(id).orElse(null);
        if (user != null) {
            user.setStatus("ONLINE");
            userRepository.save(user);
        }
    }

    public void setStatusOff(Integer id) {
        User user = getUserById(id).orElse(null);
        if (user != null) {
            user.setStatus("OFFLINE");
            userRepository.save(user);
        }
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
