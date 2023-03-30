package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantResponse;
import com.example.funskatebackend.funskate.dto.eventparticipantgroup.EventParticipantGroupRequest;
import com.example.funskatebackend.funskate.dto.eventparticipantgroup.EventParticipantGroupResponse;
import com.example.funskatebackend.funskate.entity.*;
import com.example.funskatebackend.funskate.repository.EventParticipantGroupRepository;
import com.example.funskatebackend.funskate.repository.EventParticipantRepository;
import com.example.funskatebackend.funskate.repository.SkateGroupRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static com.example.funskatebackend.funskate.dto.eventparticipantgroup.EventParticipantGroupRequest.getEventParticipantGroupEntity;

@Service
public class EventParticipantGroupService {

  EventParticipantGroupRepository eventParticipantGroupRepository;
  EventParticipantRepository eventParticipantRepository;
  SkateGroupRepository skateGroupRepository;

  public EventParticipantGroupService(EventParticipantGroupRepository eventParticipantGroupRepository, EventParticipantRepository eventParticipantRepository, SkateGroupRepository skateGroupRepository) {
    this.eventParticipantGroupRepository = eventParticipantGroupRepository;
    this.eventParticipantRepository = eventParticipantRepository;
    this.skateGroupRepository = skateGroupRepository;
  }

  public List<EventParticipantGroupResponse> getAllEventParticipantsWithGroups() {
    List<EventParticipantGroup> eventParticipantGroups = eventParticipantGroupRepository.findAll();
    return eventParticipantGroups.stream().map(epg -> new EventParticipantGroupResponse(epg, true)).toList();
  }

  public void deleteParticipantGroups(int id) {
    eventParticipantGroupRepository.deleteByEventParticipant_Id(id);
  }

  public EventParticipantGroupResponse addEventParticipantGroups(EventParticipantResponse eventParticipantResponse, boolean element, String free) {
    int eventParticipantId = Integer.parseInt(Long.toString(eventParticipantResponse.getId()));
    AthleteResponse athlete = eventParticipantResponse.getAthlete();
    LocalDate athleteBirthdate = athlete.getBirthdate();
    int athleteClubMark = athlete.getClubMark();
    List<SkateGroup> skateGroups = skateGroupRepository.findAll();
    List<SkateGroup> filteredGroupsElement;
    List<SkateGroup> filteredGroupsFree;
    SkateGroup elementSkateGroup = null;
    SkateGroup freeSkateGroup = null;
    GroupType groupType = null;
    LocalDate cutDate = LocalDate.of(2022, 7, 1);

    int age = Period.between(athleteBirthdate, cutDate).getYears();

    System.out.println("The athlete's age at the cut date was " + age + " years.");


    if (element) {
      filteredGroupsElement = skateGroups.stream().filter(skateGroup -> !skateGroup.getName().contains("Free")).toList();
      filteredGroupsElement = filteredGroupsElement.stream().filter(skateGroup -> age >= skateGroup.getMinAge() && age < skateGroup.getMaxAge()).toList();
      elementSkateGroup = filteredGroupsElement.stream().filter(skateGroup -> skateGroup.getClubMark() == athleteClubMark).findFirst().orElse(null);

    }
    if (!free.equals("")) {
      filteredGroupsFree = skateGroups.stream().filter(skateGroup -> skateGroup.getName().contains("Free")).toList();
      filteredGroupsFree = filteredGroupsFree.stream().filter(skateGroup -> age >= skateGroup.getMinAge() && age < skateGroup.getMaxAge()).toList();
      freeSkateGroup = filteredGroupsFree.stream().filter(skateGroup -> skateGroup.getClubMark() == athleteClubMark).findFirst().orElse(null);
      if (free.equals("SOLO")) {
        groupType = GroupType.SOLO;
      } else
        groupType = GroupType.DANCE;
    }
    if (free.equals("")) {
      groupType = GroupType.ELEMENT;
    }
    EventParticipantGroup eventParticipantGroup = new EventParticipantGroup(eventParticipantRepository.getReferenceById(eventParticipantId), elementSkateGroup, freeSkateGroup, groupType);

  eventParticipantGroup = eventParticipantGroupRepository.save(eventParticipantGroup);

  return new EventParticipantGroupResponse(eventParticipantGroup, true);
  }
}
