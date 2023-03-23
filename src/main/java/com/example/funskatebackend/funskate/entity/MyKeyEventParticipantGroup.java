package com.example.funskatebackend.funskate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyKeyEventParticipantGroup implements Serializable {

  @Column(name = "event_participant_id")
  private Long eventParticipantId;

  @Column(name = "skate_group_id")
  private int skateGroupId;
}
