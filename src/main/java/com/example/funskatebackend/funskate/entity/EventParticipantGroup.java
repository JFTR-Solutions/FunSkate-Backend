package com.example.funskatebackend.funskate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EventParticipantGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_participant_id")
    private EventParticipant eventParticipant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private SkateGroup skateGroup;

    public EventParticipantGroup(EventParticipant eventParticipant, SkateGroup skateGroup) {
        this.eventParticipant = eventParticipant;
        this.skateGroup = skateGroup;
    }
}