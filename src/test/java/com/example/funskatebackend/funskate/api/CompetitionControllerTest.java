package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.CompetitionType;
import com.example.funskatebackend.funskate.repository.CompetitionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CompetitionControllerTest {

     @Autowired
     CompetitionRepository competitionRepository;

    @BeforeEach
    void setUp() {
        Competition competition1 = new Competition(LocalDate.of(2023, 7, 1),
                LocalDate.of(2023, 7, 10), LocalDate.of(2023, 6, 15),
                CompetitionType.FINALS, null);
        Competition competition2 = new Competition(LocalDate.of(2024, 7, 1), LocalDate.of(2023, 7, 10),
                LocalDate.of(2023, 6, 15), CompetitionType.EAST, null);
        Competition competition3 = new Competition(LocalDate.of(2025, 7, 1), LocalDate.of(2023, 7, 10), LocalDate.of(2023, 6, 15),
                CompetitionType.WEST, null);

        competitionRepository.save(competition1);
        competitionRepository.save(competition2);
        competitionRepository.save(competition3);

    }

    @Test
    void getCompetitions() {
       List<Competition> compList = competitionRepository.findAll();

       assertEquals(3, compList.size());
    }

    @Test
    void getCompetitionById() {
        Competition competition = competitionRepository.findAll().get(1);

        assertEquals(LocalDate.of(2024, 7, 1), competition.getStartDate());
    }

    @Test
    void getCompetitionsByCompType() {
        List<Competition> compList = competitionRepository.findAllByCompetitionType(CompetitionType.WEST);

        assertEquals(1, compList.size());
    }

    @Test
    void deleteCompetitionById() {
        Competition competition = competitionRepository.findAll().get(0);
        competitionRepository.deleteById(competition.getId());

        assertEquals(2, competitionRepository.findAll().size());
    }
}