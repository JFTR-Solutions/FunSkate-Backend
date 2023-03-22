package com.example.funskatebackend.clubAthleteTest;


import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.entity.CompetitionType;
import com.example.funskatebackend.funskate.repository.AthleteRepository;
import com.example.funskatebackend.funskate.repository.ClubRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class ClubAthleteTest {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private AthleteRepository athleteRepository;

    @Test
    public void testClubAthleteRelationship() {
        // Create a club
        Club club = new Club();
        club.setName("Test Club");
        club.setLogo("Test Logo");
        club.setEastWest(CompetitionType.EAST);

        // Save the club
        clubRepository.save(club);

        // Create an athlete
        Athlete athlete = new Athlete();
        athlete.setFirstName("John");
        athlete.setLastName("Doe");
        athlete.setBirthdate(LocalDate.of(1990, 1, 1));
        athlete.setClubMark(100);
        athlete.setCompetitionNumber(1);
        athlete.setClub(club);

        // Save the athlete
        athleteRepository.save(athlete);

        // Retrieve the club and athletes
        Club savedClub = clubRepository.findById(club.getId()).orElse(null);
        List<Athlete> savedAthletes = athleteRepository.findAll();

        // Check if the club has the athlete
        assertThat(savedClub).isNotNull();


        // Check if the athlete has the club
        assertThat(savedAthletes).hasSize(1);
        assertThat(savedAthletes.get(0).getClub().getId()).isEqualTo(club.getId());

    }
}
