package com.example.funskatebackend.funskate.repository;

import com.example.funskatebackend.funskate.entity.EventParticipantGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventParticipantGroupRepository extends JpaRepository<EventParticipantGroup, Integer> {

}
