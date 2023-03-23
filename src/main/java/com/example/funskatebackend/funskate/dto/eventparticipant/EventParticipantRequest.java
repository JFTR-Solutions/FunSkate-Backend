package com.example.funskatebackend.funskate.dto.eventparticipant;

import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.EventParticipant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventParticipantRequest {
  private Athlete athlete;
  private Competition competition;

  public static EventParticipant getEventParticipantEntity(EventParticipantRequest e) {
    return new EventParticipant(e.athlete, e.competition);
  }

  public EventParticipantRequest(EventParticipant e) {
    this.athlete = e.getAthlete();
    this.competition = e.getCompetition();
  }

}
