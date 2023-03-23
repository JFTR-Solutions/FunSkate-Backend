package com.example.funskatebackend.funskate.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "location")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "street_name", nullable = false)
  private String streetName;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "zip_code", nullable = false)
  private String zipCode;

  @Column(name = "name", nullable = false)
  private String name;

  public Location(String streetName, String city, String zipCode, String name) {
    this.streetName = streetName;
    this.city = city;
    this.zipCode = zipCode;
    this.name = name;
  }
}
