package com.example.funskatebackend.funskate.dto.competition;


import com.example.funskatebackend.funskate.entity.Competition;
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

  public static Competition getCompetitionEntity(CompetitionRequest c) {
    return new Competition(c.id, c.startDate,c.endDate,c.deadline);
  }

  public CompetitionRequest(Competition c) {
    this.id = c.getId();
    this.startDate = c.getStartDate();
    this.endDate = c.getEndDate();
    this.deadline = c.getDeadline();
  }
}
