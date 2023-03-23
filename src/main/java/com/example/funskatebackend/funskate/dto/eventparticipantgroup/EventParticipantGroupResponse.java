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
public class EventParticipantGroupResponse {

  private int id;
  private EventParticipant eventParticipant;
  private SkateGroup freeSkateGroup;
  private SkateGroup elementSkateGroup;
  private GroupType groupType;

  public EventParticipantGroupResponse(EventParticipantGroup g) {
    this.id = g.getId();
    this.eventParticipant = g.getEventParticipant();
    this.freeSkateGroup = g.getFreeSkateGroup();
    this.elementSkateGroup = g.getElementSkateGroup();
    this.groupType = g.getGroupType();
  }
}
