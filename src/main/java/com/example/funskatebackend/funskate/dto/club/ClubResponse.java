package com.example.funskatebackend.funskate.dto.club;

import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.entity.CompetitionType;
import com.example.funskatebackend.funskate.entity.Location;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClubResponse {

  private int id;
  private String name;
  private String logo;
  private String abbreviation;
  private List<AthleteResponse> athletes;
  private Location location;
  private CompetitionType eastWest;


  public ClubResponse(Club c, boolean withAthletes) {
    this.id = c.getId();
    this.name = c.getName();
    this.abbreviation = c.getAbbreviation();
    this.logo = c.getLogo();
    this.location = c.getLocation();
    this.eastWest = c.getEastWest();
    if (withAthletes) {
      this.athletes = c.getAthletes().stream().map(athlete -> new AthleteResponse(athlete, false,true)).toList();
    }
  }
}

