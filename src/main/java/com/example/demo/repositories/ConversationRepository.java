package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Conversation;
import java.util.List;
import java.util.Set;
import com.example.demo.models.Participant;


@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Integer>{
    List<Conversation> findByParticipants(Set<Participant> participants);
}
