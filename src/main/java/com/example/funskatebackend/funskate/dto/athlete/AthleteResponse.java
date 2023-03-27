package com.example.funskatebackend.funskate.dto.athlete;

import com.example.funskatebackend.funskate.dto.club.ClubResponse;
import com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantResponse;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Club;
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
public class AthleteResponse {

  int id;
  String firstName;
  String lastName;
  LocalDate birthdate;
  int clubMark;
  int competitionNumber;
  ClubResponse clubResponse;
  List<EventParticipantResponse> eventParticipants;

  public AthleteResponse(Athlete a, boolean withClub, boolean withEvents) {
    this.id = a.getId();
    this.firstName = a.getFirstName();
    this.lastName = a.getLastName();
    this.birthdate = a.getBirthdate();
    this.clubMark = a.getClubMark();
    this.competitionNumber = a.getCompetitionNumber();
    if (withClub) {
      this.clubResponse = new ClubResponse(a.getClub(), false);
    }
    if (withEvents) {
      this.eventParticipants = a.getEventParticipants().stream().map(eventParticipant -> new EventParticipantResponse(eventParticipant,false,true)).toList();
    }
  }
}
