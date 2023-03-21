package com.example.funskatebackend.funskate.configuration;

import com.example.funskatebackend.funskate.entity.*;
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
    LocationRepository locationRepository;
    @Autowired
    EventParticipantRepository eventParticipantRepository;
    @Autowired
    EventParticipantGroupRepository eventParticipantGroupRepository;
    @Autowired
    SkateGroupRepository skateGroupRepository;
    @Autowired
    EventParticipantService eventParticipantService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Location loc1 = new Location("Main Street", "New York City", "10001", "Empire State Building");
        Location loc2 = new Location("Broadway", "Los Angeles", "90028", "Hollywood Walk of Fame");
        Location loc3 = new Location("Rue du Faubourg Saint-Honoré", "Paris", "75008", "Champs-Élysées");
        Location loc4 = new Location("Fifth Avenue", "New York City", "10153", "Rockefeller Center");

        locationRepository.save(loc1);
        locationRepository.save(loc2);
        locationRepository.save(loc3);
        locationRepository.save(loc4);

        Club club1 = new Club( "Team Alpha", "https://example.com/teamalpha.png", loc1);
        Club club2 = new Club( "Team Beta", "https://example.com/teambeta.png",loc2);
        clubRepository.save(club1);
        clubRepository.save(club2);

        Athlete athlete1 = new Athlete("John", "Doe", LocalDate.of(1995, 5, 12), 1500, 1234);
        Athlete athlete2 = new Athlete("Jane", "Smith", LocalDate.of(1998, 9, 3), 1800, 5678);
        Athlete athlete3 = new Athlete("Bob", "Johnson", LocalDate.of(1990, 2, 22), 1200, 9012);



        athlete1.setClub(club1);
        athlete2.setClub(club1);
        athlete3.setClub(club2);


        athleteRepository.save(athlete1);
        athleteRepository.save(athlete2);
        athleteRepository.save(athlete3);


        Competition competition1 = new Competition(1, LocalDate.of(2023, 7, 1), LocalDate.of(2023, 7, 10), LocalDate.of(2023, 6, 15));

        competitionRepository.save(competition1);

        // FunBubbles Groups
        SkateGroup funBubbles1 = new SkateGroup("FunBubbles 1", 2, 0, 8);
        SkateGroup funBubbles2 = new SkateGroup("FunBubbles 2", 2, 8, 10);
        SkateGroup funBubbles3 = new SkateGroup("FunBubbles 3", 2, 10, 18);
        SkateGroup funBubbles4 = new SkateGroup("FunBubbles 4", 2, 18, Integer.MAX_VALUE);

// FunFlakes Groups
        SkateGroup funFlakes1 = new SkateGroup("FunFlakes 1", 3, 0, 10);
        SkateGroup funFlakes2 = new SkateGroup("FunFlakes 2", 3, 10, 12);
        SkateGroup funFlakes3 = new SkateGroup("FunFlakes 3", 3, 12, 18);

// FunCubes Groups
        SkateGroup funCubes1 = new SkateGroup("FunCubes 1", 4, 0, 11);
        SkateGroup funCubes2 = new SkateGroup("FunCubes 2", 4, 11, 13);
        SkateGroup funCubes3 = new SkateGroup("FunCubes 3", 4, 13, 18);
        SkateGroup funCubes4 = new SkateGroup("FunCubes 4", 5, 18, Integer.MAX_VALUE);

// FunCrystals Groups
        SkateGroup funCrystals1 = new SkateGroup("FunCrystals 1", 6, 0, 11);
        SkateGroup funCrystals2 = new SkateGroup("FunCrystals 2", 6, 11, 13);
        SkateGroup funCrystals3 = new SkateGroup("FunCrystals 3", 6, 13, 18);


          skateGroupRepository.save(funBubbles1);
            skateGroupRepository.save(funBubbles2);
            skateGroupRepository.save(funBubbles3);
            skateGroupRepository.save(funBubbles4);
            skateGroupRepository.save(funFlakes1);
            skateGroupRepository.save(funFlakes2);
            skateGroupRepository.save(funFlakes3);
            skateGroupRepository.save(funCubes1);
            skateGroupRepository.save(funCubes2);
            skateGroupRepository.save(funCubes3);
            skateGroupRepository.save(funCubes4);
            skateGroupRepository.save(funCrystals1);
            skateGroupRepository.save(funCrystals2);
            skateGroupRepository.save(funCrystals3);


        EventParticipant eventParticipant = eventParticipantService.addEventParticipant(athlete1, competition1);

        EventParticipantGroup epg1 = new EventParticipantGroup();
        epg1.setEventParticipant(eventParticipant);
        epg1.setSkateGroup(funBubbles1);
        eventParticipantGroupRepository.save(epg1);

        EventParticipantGroup epg2 = new EventParticipantGroup();
        epg2.setEventParticipant(eventParticipant);
        epg2.setSkateGroup(funCubes2);
        eventParticipantGroupRepository.save(epg2);

        EventParticipant eventParticipant2 = eventParticipantService.addEventParticipant(athlete2, competition1);

        EventParticipantGroup epg3 = new EventParticipantGroup();
        epg3.setEventParticipant(eventParticipant2);
        epg3.setSkateGroup(funFlakes3);
        eventParticipantGroupRepository.save(epg3);

        EventParticipantGroup epg4 = new EventParticipantGroup();
        epg4.setEventParticipant(eventParticipant2);
        epg4.setSkateGroup(funCrystals2);
        eventParticipantGroupRepository.save(epg4);

        EventParticipant eventParticipant3 = eventParticipantService.addEventParticipant(athlete3, competition1);

        EventParticipantGroup epg5 = new EventParticipantGroup();
        epg5.setEventParticipant(eventParticipant3);
        epg5.setSkateGroup(funBubbles4);
        eventParticipantGroupRepository.save(epg5);



    }


}
