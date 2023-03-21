package com.example.funskatebackend.funskate.dto.competition;


import com.example.funskatebackend.funskate.entity.Competition;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompetitionResponse {
  int id;
  LocalDate startDate;
  LocalDate endDate;
  LocalDate deadline;

  public CompetitionResponse(Competition c) {
    this.id = c.getId();
    this.startDate = c.getStartDate();
    this.endDate = c.getEndDate();
    this.deadline = c.getDeadline();
  }
}
