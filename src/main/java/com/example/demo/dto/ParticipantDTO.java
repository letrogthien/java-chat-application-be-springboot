package com.example.demo.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDTO {
    private int id;
    private int userId;
    private int conversationId;
    private Timestamp joinedAt;
    private boolean isAdmin;

    // Getters and Setters...
}