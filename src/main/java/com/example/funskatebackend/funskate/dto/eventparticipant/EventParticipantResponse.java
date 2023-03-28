package com.example.funskatebackend.funskate.dto.eventparticipant;

import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.EventParticipant;
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

    public EventParticipantResponse(EventParticipant e, boolean withAthlete, boolean withCompetition) {
        this.id = e.getId();
        if (withAthlete) {
            this.athlete = new AthleteResponse(e.getAthlete(), true, false);
        }
        if (withCompetition) {
            this.competition = e.getCompetition();
        }
    }
}