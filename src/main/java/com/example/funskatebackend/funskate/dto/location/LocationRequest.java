package com.example.funskatebackend.funskate.dto.location;

import com.example.funskatebackend.funskate.dto.competition.CompetitionRequest;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.Location;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationRequest {

  private int id;
  private String streetName;
  private String city;
  private String zipCode;
  private String name;

  public static Location getLocationEntity(LocationRequest l) {
    return new Location(l.id, l.streetName, l.city, l.zipCode, l.name);
  }

  public LocationRequest(Location l) {
    this.id = l.getId();
    this.streetName = l.getStreetName();
    this.city = l.getCity();
    this.zipCode = l.getZipCode();
    this.name = l.getName();
  }
}
