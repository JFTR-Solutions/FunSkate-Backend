package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantRequest;
import com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantResponse;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.EventParticipant;
import com.example.funskatebackend.funskate.repository.EventParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantRequest.getEventParticipantEntity;

@Service
public class EventParticipantService {

  EventParticipantRepository eventParticipantRepository;

  public EventParticipantService(EventParticipantRepository eventParticipantRepository) {
    this.eventParticipantRepository = eventParticipantRepository;
  }

  public EventParticipantResponse addEventParticipant(EventParticipantRequest eventParticipantRequest) {
      EventParticipant eventParticipant = getEventParticipantEntity(eventParticipantRequest);
      eventParticipant = eventParticipantRepository.save(eventParticipant);
      return new EventParticipantResponse(eventParticipant, true, true);
  }

  public List<EventParticipantResponse> getAllParticipantsForEventByEventId(int id) {
    List<EventParticipant> eventParticipants = eventParticipantRepository.findEventParticipantByCompetition_Id(id);

    return eventParticipants.stream().map(ep -> new EventParticipantResponse(ep, true, false)).toList();
  }

  public void deleteParticipant(int compId, int partId) {
    eventParticipantRepository.deleteByCompetition_IdAndAthlete_id(compId, partId);
  }
}
