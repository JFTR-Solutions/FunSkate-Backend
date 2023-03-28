package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantRequest;
import com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantResponse;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.EventParticipant;
import com.example.funskatebackend.funskate.repository.EventParticipantRepository;
import com.example.funskatebackend.security.entity.Role;
import com.example.funskatebackend.security.entity.UserWithRoles;
import com.example.funskatebackend.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantRequest.getEventParticipantEntity;

@Service
public class EventParticipantService {

  EventParticipantRepository eventParticipantRepository;
  UserWithRolesRepository userWithRolesRepository;


  public EventParticipantService(EventParticipantRepository eventParticipantRepository,
                                 UserWithRolesRepository userWithRolesRepository) {
    this.eventParticipantRepository = eventParticipantRepository;
    this.userWithRolesRepository = userWithRolesRepository;
  }

  public EventParticipantResponse addEventParticipant(EventParticipantRequest eventParticipantRequest) {
      EventParticipant eventParticipant = getEventParticipantEntity(eventParticipantRequest);
      eventParticipant = eventParticipantRepository.save(eventParticipant);
      return new EventParticipantResponse(eventParticipant, true, true);
  }

/*  public List<EventParticipantResponse> getAllParticipantsForEventByEventId(int id) {
    List<EventParticipant> eventParticipants = eventParticipantRepository.findEventParticipantByCompetition_Id(id);

    return eventParticipants.stream().map(ep -> new EventParticipantResponse(ep, true, false)).toList();
  }*/
public List<EventParticipantResponse> getAllParticipantsForEventByEventId(int eventId) {
  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
  String currentUsername = authentication.getName();
  UserWithRoles currentUser = userWithRolesRepository.findByUsername(currentUsername);

  if (currentUser.getRoles().contains(Role.ADMIN)) {
    List<EventParticipant> eventParticipants = eventParticipantRepository.findEventParticipantByCompetition_Id(eventId);
    return eventParticipants.stream()
            .map(ep -> new EventParticipantResponse(ep, true, false))
            .collect(Collectors.toList());
  } else if (currentUser.getRoles().contains(Role.USER)) {
    Club currentClub = currentUser.getClub();
    List<EventParticipant> eventParticipants = eventParticipantRepository
            .findEventParticipantByCompetition_IdAndAthlete_Club(eventId, currentClub);
    return eventParticipants.stream()
            .map(ep -> new EventParticipantResponse(ep, true, false))
            .collect(Collectors.toList());
  } else {
    throw new IllegalStateException("Unknown user role: " + currentUser.getRoles());
  }
}

  public void deleteParticipant(int compId, int partId) {
    eventParticipantRepository.deleteByCompetition_IdAndAthlete_id(compId, partId);
  }
}
