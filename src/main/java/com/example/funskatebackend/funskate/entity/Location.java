package com.example.funskatebackend.funskate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "location")
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

}
