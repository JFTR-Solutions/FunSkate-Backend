package com.example.funskatebackend.funskate.repository;

import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.entity.EventParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventParticipantRepository extends JpaRepository<EventParticipant, Integer> {
}
