package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Participant;
import com.example.demo.models.User;

import java.util.List;


@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    List<Participant> findByUser(User user);
}
