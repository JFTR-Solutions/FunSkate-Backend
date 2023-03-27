package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.repository.AthleteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AthleteControllerTest {

    @Autowired
    AthleteRepository athleteRepository;


    @BeforeEach
    void setUp() {
        Athlete athlete1 = new Athlete("John", "Doe", LocalDate.of(1995, 5, 12), 1500, 1234, null);
        Athlete athlete2 = new Athlete("Jane", "Smith", LocalDate.of(1998, 9, 3), 1800, 5678, null);

        athleteRepository.save(athlete1);
        athleteRepository.save(athlete2);
    }


    @Test
    void getAthletes() {

        assertEquals(2, athleteRepository.findAll().size());
    }
}