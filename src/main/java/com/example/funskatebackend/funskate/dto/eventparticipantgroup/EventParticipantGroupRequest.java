package com.example.funskatebackend.funskate.dto.eventparticipantgroup;


import com.example.funskatebackend.funskate.entity.EventParticipant;
import com.example.funskatebackend.funskate.entity.EventParticipantGroup;
import com.example.funskatebackend.funskate.entity.GroupType;
import com.example.funskatebackend.funskate.entity.SkateGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EventParticipantGroupRequest {

  private EventParticipant eventParticipant;
  private SkateGroup elementSkateGroup;
  private SkateGroup freeSkateGroup;
  private GroupType groupType;

  public EventParticipantGroupRequest(EventParticipantGroup g) {
    this.eventParticipant = g.getEventParticipant();
    this.elementSkateGroup = g.getElementSkateGroup();
    this.freeSkateGroup = g.getFreeSkateGroup();
    this.groupType = g.getGroupType();
  }
}