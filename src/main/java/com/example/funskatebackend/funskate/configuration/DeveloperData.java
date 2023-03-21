package com.example.funskatebackend.funskate.configuration;

import com.example.funskatebackend.funskate.dto.event.EventParticipantRequest;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.EventParticipant;
import com.example.funskatebackend.funskate.repository.*;
import com.example.funskatebackend.funskate.service.EventParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DeveloperData implements ApplicationRunner {

    @Autowired
    AthleteRepository athleteRepository;
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    CompetitionRepository competitionRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    EventParticipantRepository eventParticipantRepository;
    @Autowired
    EventParticipantService eventParticipantService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Athlete athlete1 = new Athlete("John", "Doe", LocalDate.of(1995, 5, 12), 1500, 1234);
        Athlete athlete2 = new Athlete("Jane", "Smith", LocalDate.of(1998, 9, 3), 1800, 5678);
        Athlete athlete3 = new Athlete("Bob", "Johnson", LocalDate.of(1990, 2, 22), 1200, 9012);

        athleteRepository.save(athlete1);
        athleteRepository.save(athlete2);
        athleteRepository.save(athlete3);

        Club club1 = new Club(1, "Team Alpha", "https://example.com/teamalpha.png");
        Club club2 = new Club(2, "Team Beta", "https://example.com/teambeta.png");

        clubRepository.save(club1);
        clubRepository.save(club2);

        Competition competition1 = new Competition(1, LocalDate.of(2023, 7, 1), LocalDate.of(2023, 7, 10), LocalDate.of(2023, 6, 15));

        competitionRepository.save(competition1);

        EventParticipant eventParticipant = eventParticipantService.addEventParticipant(athlete1, competition1);

    }
}
