package com.example.demo.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Conversation;
import com.example.demo.models.Participant;
import com.example.demo.repositories.ConversationRepository;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;

    public List<Conversation> getByParticipant(Set<Participant> participants){
        return conversationRepository.findByParticipants(participants);
    }
}
