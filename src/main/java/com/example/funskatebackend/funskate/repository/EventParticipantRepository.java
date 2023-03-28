package com.example.funskatebackend.funskate.repository;

import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.entity.EventParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventParticipantRepository extends JpaRepository<EventParticipant, Integer> {

  List<EventParticipant> findEventParticipantByCompetition_Id(int id);
  void deleteByCompetition_IdAndAthlete_id(int compId, int partId);

  List<EventParticipant> findEventParticipantByCompetition_IdAndAthlete_Club(int eventId, Club currentClub);
}
