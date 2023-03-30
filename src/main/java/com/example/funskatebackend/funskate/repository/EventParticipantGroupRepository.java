package com.example.funskatebackend.funskate.repository;

import com.example.funskatebackend.funskate.entity.EventParticipantGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventParticipantGroupRepository extends JpaRepository<EventParticipantGroup, Integer> {

  void deleteByEventParticipant_Id(int id);
}
