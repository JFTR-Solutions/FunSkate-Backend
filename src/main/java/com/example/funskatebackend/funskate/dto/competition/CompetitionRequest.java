package com.example.funskatebackend.funskate.dto.competition;


import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.CompetitionType;
import com.example.funskatebackend.funskate.entity.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CompetitionRequest {
  private int id;
  private LocalDate startDate;
  private LocalDate endDate;
  private LocalDate deadline;
  private CompetitionType competitionType;
  private Location location;

  public static Competition getCompetitionEntity(CompetitionRequest c) {
    return new Competition(c.startDate,c.endDate,c.deadline, c.competitionType, c.location);
  }

  public CompetitionRequest(Competition c) {
    this.id = c.getId();
    this.startDate = c.getStartDate();
    this.endDate = c.getEndDate();
    this.deadline = c.getDeadline();
    this.competitionType = c.getCompetitionType();
    this.location = c.getLocation();
  }
}
