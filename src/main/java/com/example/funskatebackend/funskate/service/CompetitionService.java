package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.dto.competition.CompetitionRequest;
import com.example.funskatebackend.funskate.dto.competition.CompetitionResponse;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.repository.CompetitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {

  CompetitionRepository competitionRepository;

  public CompetitionService(CompetitionRepository competitionRepository) {
    this.competitionRepository = competitionRepository;
  }

  public List<CompetitionResponse> getAllCompetitions() {
    List<Competition> competitions = competitionRepository.findAll();

    return competitions.stream().map(c -> new CompetitionResponse()).toList();
  }


  public CompetitionResponse addCompetition(CompetitionRequest competitionRequest) {
    Competition newCompetition = CompetitionRequest.getCompetitionEntity(competitionRequest);
    newCompetition = competitionRepository.save(newCompetition);

    return new CompetitionResponse(newCompetition);
  }

  public void deleteCompetitionById(int id) {
    competitionRepository.deleteById(id);
  }
}
