package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.competition.CompetitionRequest;
import com.example.funskatebackend.funskate.dto.competition.CompetitionResponse;
import com.example.funskatebackend.funskate.service.CompetitionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/competitions")
public class CompetitionController {

  CompetitionService competitionService;

  public CompetitionController(CompetitionService competitionService) {
    this.competitionService = competitionService;
  }

  @GetMapping
  List<CompetitionResponse> getCompetitions() {
    return competitionService.getAllCompetitions();
  }
  @GetMapping("/{comp_type}")
  List<CompetitionResponse> getCompetitionsByCompType(@PathVariable String comp_type) {
    return competitionService.getCompetitionsByCompType(comp_type);
  }

  @PostMapping
  CompetitionResponse addCompetition(@RequestBody CompetitionRequest body) {
    return competitionService.addCompetition(body);
  }

  @DeleteMapping("/{id}")
  public void deleteCompetitionById(@PathVariable int id) {
    competitionService.deleteCompetitionById(id);
  }
}
