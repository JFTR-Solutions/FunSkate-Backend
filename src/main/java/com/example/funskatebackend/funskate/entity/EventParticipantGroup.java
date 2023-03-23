package com.example.funskatebackend.funskate.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "event_participant_group")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EventParticipantGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "event_participant_id")
  private EventParticipant eventParticipant;

  @ManyToOne
  @JoinColumn(name = "free_skate_group_id")
  private SkateGroup freeSkateGroup;

  @ManyToOne
  @JoinColumn(name = "element_skate_group_id")
  private SkateGroup elementSkateGroup;

  @Enumerated(EnumType.STRING)
  @Column(name = "free_type")
  private GroupType groupType;

  public EventParticipantGroup(EventParticipant eventParticipant,SkateGroup elementSkateGroup, SkateGroup freeSkateGroup, GroupType groupType) {
    this.eventParticipant = eventParticipant;
    this.elementSkateGroup = elementSkateGroup;
    this.freeSkateGroup = freeSkateGroup;
    this.groupType = groupType;
  }
}