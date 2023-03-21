package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.dto.event.EventParticipantRequest;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.EventParticipant;
import com.example.funskatebackend.funskate.repository.EventParticipantRepository;
import org.springframework.stereotype.Service;

@Service
public class EventParticipantService {

    EventParticipantRepository eventParticipantRepository;

    public EventParticipantService(EventParticipantRepository eventParticipantRepository) {
        this.eventParticipantRepository = eventParticipantRepository;
    }

    public EventParticipant addEventParticipant(Athlete athlete, Competition competition) {
        EventParticipant eventParticipant = new EventParticipant();
        eventParticipant.setAthlete(athlete);
        eventParticipant.setCompetition(competition);
        return eventParticipantRepository.save(eventParticipant);
    }
}
