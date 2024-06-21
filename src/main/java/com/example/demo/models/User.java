package com.example.demo.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

import com.example.demo.socket.UserStatus;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 45)
    private String username;

    @Column(nullable = false, length = 250)
    private String password;

    @Column(nullable = false, length = 45)
    private String phone;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(length = 100)
    private String fullname;

    @Column(length = 45)
    private String nickname;

    @Column(length = 45)
    private String status;


    // Constructors, Getters, and Setters...
}