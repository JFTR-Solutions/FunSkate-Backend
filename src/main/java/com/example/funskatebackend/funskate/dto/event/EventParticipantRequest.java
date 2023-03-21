package com.example.funskatebackend.funskate.dto.event;


import com.example.funskatebackend.funskate.entity.EventParticipant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventParticipantRequest {
    private int athleteId;
    private int competitionId;

}
