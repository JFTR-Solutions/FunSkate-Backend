package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantRequest;
import com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantResponse;
import com.example.funskatebackend.funskate.entity.*;
import com.example.funskatebackend.funskate.repository.AthleteRepository;
import com.example.funskatebackend.funskate.repository.EventParticipantGroupRepository;
import com.example.funskatebackend.funskate.repository.EventParticipantRepository;
import com.example.funskatebackend.security.entity.Role;
import com.example.funskatebackend.security.entity.UserWithRoles;
import com.example.funskatebackend.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantRequest.getEventParticipantEntity;

@Service
public class EventParticipantService {

  EventParticipantRepository eventParticipantRepository;
  EventParticipantGroupRepository eventParticipantGroupRepository;
  UserWithRolesRepository userWithRolesRepository;
  AthleteRepository athleteRepository;


  public EventParticipantService(EventParticipantRepository eventParticipantRepository, EventParticipantGroupRepository eventParticipantGroupRepository, UserWithRolesRepository userWithRolesRepository, AthleteRepository athleteRepository) {
    this.eventParticipantRepository = eventParticipantRepository;
    this.eventParticipantGroupRepository = eventParticipantGroupRepository;
    this.userWithRolesRepository = userWithRolesRepository;
    this.athleteRepository = athleteRepository;
  }

  public EventParticipantResponse addEventParticipant(EventParticipantRequest eventParticipantRequest) {
      EventParticipant eventParticipant = getEventParticipantEntity(eventParticipantRequest);
      eventParticipant = eventParticipantRepository.save(eventParticipant);
      return new EventParticipantResponse(eventParticipant, true, true,false);
  }

public List<EventParticipantResponse> getAllParticipantsForEventByEventId(int eventId) {
  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
  String currentUsername = authentication.getName();
  UserWithRoles currentUser = userWithRolesRepository.findByUsername(currentUsername);

  if (currentUser.getRoles().contains(Role.ADMIN)) {
    List<EventParticipant> eventParticipants = eventParticipantRepository.findEventParticipantByCompetition_Id(eventId);
    return eventParticipants.stream()
            .map(ep -> new EventParticipantResponse(ep, true, false,true))
            .collect(Collectors.toList());
  } else if (currentUser.getRoles().contains(Role.USER)) {
    Club currentClub = currentUser.getClub();
    List<EventParticipant> eventParticipants = eventParticipantRepository
            .findEventParticipantByCompetition_IdAndAthlete_Club(eventId, currentClub);
    return eventParticipants.stream()
            .map(ep -> new EventParticipantResponse(ep, true, false,true))
            .collect(Collectors.toList());
  } else {
    throw new IllegalStateException("Unknown user role: " + currentUser.getRoles());
  }
}

  public void deleteParticipant(int compId, int partId) {
    eventParticipantRepository.deleteByCompetition_IdAndAthlete_id(compId, partId);
  }


  public EventParticipantResponse getEventParticipantById(int id) {
  EventParticipant newEventParticipant = eventParticipantRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "EventParticipant not found"));
  return new EventParticipantResponse(newEventParticipant,true, true, false);
  }
}
