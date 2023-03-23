package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.dto.competition.CompetitionRequest;
import com.example.funskatebackend.funskate.dto.competition.CompetitionResponse;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.CompetitionType;
import com.example.funskatebackend.funskate.repository.CompetitionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompetitionService {

  CompetitionRepository competitionRepository;

  public CompetitionService(CompetitionRepository competitionRepository) {
    this.competitionRepository = competitionRepository;
  }

  public List<CompetitionResponse> getAllCompetitions() {
    List<Competition> competitions = competitionRepository.findAll();

    return competitions.stream().map(competition -> new CompetitionResponse(competition, false)).toList();
  }


  public CompetitionResponse addCompetition(CompetitionRequest competitionRequest) {
    Competition newCompetition = CompetitionRequest.getCompetitionEntity(competitionRequest);
    newCompetition = competitionRepository.save(newCompetition);

    return new CompetitionResponse(newCompetition, false);
  }

  public void deleteCompetitionById(int id) {
    competitionRepository.deleteById(id);
  }

  public List<CompetitionResponse> getCompetitionsByCompType(String compType) {
    List<Competition> competitions = competitionRepository.findAllByCompetitionType(CompetitionType.valueOf(compType));
    return competitions.stream().map(competition -> new CompetitionResponse(competition, true)).toList();
  }

  public CompetitionResponse getCompetitionById(int id) {
    Competition competition = competitionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competition not found"));
    return new CompetitionResponse(competition, true);
  }
}
