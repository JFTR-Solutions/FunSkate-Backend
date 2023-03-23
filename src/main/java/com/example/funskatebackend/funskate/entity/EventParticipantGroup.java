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

  @EmbeddedId
  private MyKeyEventParticipantGroup id;

  @MapsId("eventParticipantId")
  @ManyToOne
  @JoinColumn(name = "event_participant_id")
  private EventParticipant eventParticipant;

  @ManyToOne
  @JoinColumn(name = "skate_group_id", insertable = false, updatable = false)
  private SkateGroup skateGroup;

  public EventParticipantGroup(EventParticipant eventParticipant, SkateGroup skateGroup) {
    this.id = new MyKeyEventParticipantGroup(eventParticipant.getId(), skateGroup.getId());
    this.eventParticipant = eventParticipant;
    this.skateGroup = skateGroup;
  }
}
