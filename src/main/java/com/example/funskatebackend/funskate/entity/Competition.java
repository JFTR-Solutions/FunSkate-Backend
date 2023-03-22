package com.example.funskatebackend.funskate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "competition")
public class Competition {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "start_date", nullable = false)
  private LocalDate startDate;

  @Column(name = "end_date", nullable = false)
  private LocalDate endDate;

  @Column(name = "deadline", nullable = false)
  private LocalDate deadline;

  @Enumerated(EnumType.STRING)
  @Column(name = "comp_type")
  private CompetitionType competitionType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "location_id")
  private Location location;

  @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL)
  private List<Competition> competitions;

  public Competition(LocalDate startDate, LocalDate endDate, LocalDate deadline, CompetitionType competitionType, Location location) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.deadline = deadline;
    this.competitionType = competitionType;
    this.location = location;
  }
}
