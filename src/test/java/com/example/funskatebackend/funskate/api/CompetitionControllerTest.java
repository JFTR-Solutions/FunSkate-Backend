package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.CompetitionType;
import com.example.funskatebackend.funskate.repository.CompetitionRepository;
import com.example.funskatebackend.funskate.service.CompetitionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
public class CompetitionControllerTest {

    @BeforeEach
    public void setUp() {


    }

//    @Test
    public void testDeleteCompetitionById() {
    }
}
