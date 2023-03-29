package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.api.AthleteController;
import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.entity.CompetitionType;
import com.example.funskatebackend.funskate.repository.AthleteRepository;
import com.example.funskatebackend.funskate.repository.ClubRepository;
import com.example.funskatebackend.security.entity.Role;
import com.example.funskatebackend.security.entity.UserWithRoles;
import com.example.funskatebackend.security.repository.UserWithRolesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class AthleteServiceTest {

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private UserWithRolesRepository userWithRolesRepository;

    @Autowired
    ClubRepository clubrepository;

    @BeforeEach
    void setUp() {
        Club club1 = new Club("Aalborg Skøjteløberforening", "", "ASF", null, CompetitionType.WEST);
        Club club2 = new Club("Aarhus Skøjteklub", "", "ASK", null, CompetitionType.WEST);

        clubrepository.save(club1);
        clubrepository.save(club2);
        athleteRepository.save(new Athlete("John", "Doe", LocalDate.of(1995, 5, 12), 3, 1234, club2));
        athleteRepository.save(new Athlete("Jane", "Doe", LocalDate.of(1995, 1, 1), 200, 2, club2));

        // create a user with the club
        UserWithRoles club1User = new UserWithRoles("ASF", "test1234", "ASF@funskate.dk", club1);
        userWithRolesRepository.save(club1User);
        club1User.addRole(Role.USER);

        // create an admin user
        UserWithRoles user1 = new UserWithRoles("admin", "test1234", "admin@funskate.dk");
        user1.addRole(Role.ADMIN);
        userWithRolesRepository.save(user1);
    }

    @Test
    void testGetAthletesForAdmin() {
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("admin", "test1234"));

        AthleteService athleteService = new AthleteService(athleteRepository, userWithRolesRepository);
        List<AthleteResponse> athletes = athleteService.getAthletes();

        assertEquals(2, athletes.size());
        assertEquals("John", athletes.get(0).getFirstName());
        assertEquals("Doe", athletes.get(0).getLastName());
        assertEquals(2, athletes.get(1).getCompetitionNumber());
        assertEquals(200, athletes.get(1).getClubMark());
        assertNotNull(athletes.get(0).getClubResponse());
        assertNull(athletes.get(0).getEventParticipants());

    }

    @Test
    public void testGetAthletesForUser() {
        // set the authentication to the regular user
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("ASF", "test1234"));

        AthleteService athleteService = new AthleteService(athleteRepository, userWithRolesRepository);
        List<AthleteResponse> athletes = athleteService.getAthletes();

//        ASSERT 0 since both athletes are under a different club than the user logged in.
        assertEquals(0, athletes.size());

    }
}