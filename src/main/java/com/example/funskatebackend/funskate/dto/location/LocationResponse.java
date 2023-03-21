package com.example.funskatebackend.funskate.dto.location;

import com.example.funskatebackend.funskate.entity.Location;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationResponse {

  private int id;
  private String streetName;
  private String city;
  private String zipCode;
  private String name;

  public LocationResponse(Location l) {
    this.id = l.getId();
    this.streetName = l.getStreetName();
    this.city = l.getCity();
    this.zipCode = l.getZipCode();
    this.name = l.getName();
  }
}
