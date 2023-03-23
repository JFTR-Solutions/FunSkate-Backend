package com.example.funskatebackend.funskate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "club")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Club {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "logo", nullable = false)
  private String logo;

  @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
  @JsonBackReference
  private List<Athlete> athletes;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "location_id")
  private Location location;

  @Enumerated(EnumType.STRING)
  @Column(name = "east_west")
  private CompetitionType eastWest;

  public Club(String name, String logo, Location location) {
    this.name = name;
    this.logo = logo;
    this.location = location;
  }

  public Club(String name, String logo, Location location, CompetitionType eastWest) {
    this.name = name;
    this.logo = logo;
    this.location = location;
    this.eastWest = eastWest;
  }
}