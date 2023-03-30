package com.example.funskatebackend.funskate.dto.eventparticipant;

import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.dto.club.ClubResponse;
import com.example.funskatebackend.funskate.dto.eventparticipantgroup.EventParticipantGroupResponse;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.EventParticipant;
import com.example.funskatebackend.funskate.entity.EventParticipantGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventParticipantResponse {

    private Long id;
    private AthleteResponse athlete;
    private Competition competition;
    private EventParticipantGroupResponse eventParticipantGroup;

    public EventParticipantResponse(EventParticipant e, boolean withAthlete, boolean withCompetition, boolean withEventParticipantGroup) {
        this.id = e.getId();
        if (withAthlete) {
            this.athlete = new AthleteResponse(e.getAthlete(), true, false);
        }
        if (withCompetition) {
            this.competition = e.getCompetition();
        }
        if (withEventParticipantGroup) {
            this.eventParticipantGroup = new EventParticipantGroupResponse(e.getEventParticipantGroup(),false);
        }

    }
}