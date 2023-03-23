package com.example.funskatebackend.funskate.dto.competition;


import com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantResponse;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.CompetitionType;
import com.example.funskatebackend.funskate.entity.Location;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompetitionResponse {
  int id;
  LocalDate startDate;
  LocalDate endDate;
  LocalDate deadline;
  CompetitionType competitionType;
  Location location;

  List<EventParticipantResponse> eventParticipants;

  public CompetitionResponse(Competition c, boolean withParticipants) {
    this.id = c.getId();
    this.startDate = c.getStartDate();
    this.endDate = c.getEndDate();
    this.deadline = c.getDeadline();
    this.competitionType = c.getCompetitionType();
    this.location = c.getLocation();
    if (withParticipants) {
      this.eventParticipants = c.getEventParticipants().stream().map(eventParticipant -> new EventParticipantResponse(eventParticipant,true, false)).toList();
    }
  }
}
