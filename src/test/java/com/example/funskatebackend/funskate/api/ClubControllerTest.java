package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.entity.CompetitionType;
import com.example.funskatebackend.funskate.repository.ClubRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClubControllerTest {

    @Autowired
    ClubRepository clubRepository;

    @BeforeEach
    void setUp() {

        Club club1 = new Club("Aalborg Skøjteløberforening", "", "ASF", null, CompetitionType.WEST);
        Club club2 = new Club("Aarhus Skøjteklub", "", "ASK", null, CompetitionType.WEST);
        Club club3 = new Club("Esbjerg Skøjteklub", "", "ESK", null, CompetitionType.WEST);
        clubRepository.save(club1);
        clubRepository.save(club2);
        clubRepository.save(club3);
    }

    @Test
    void getClubs() {
        List<Club> clubList = clubRepository.findAll();

        assertEquals(3, clubList.size());
    }

    @Test
    void getClubById() {
        Club club = clubRepository.findAll().get(0);

        assertEquals("Aalborg Skøjteløberforening", club.getName());
    }
}