package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.competition.CompetitionRequest;
import com.example.funskatebackend.funskate.dto.competition.CompetitionResponse;
import com.example.funskatebackend.funskate.service.CompetitionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("competitions")
public class CompetitionController {

  CompetitionService competitionService;

  public CompetitionController(CompetitionService competitionService) {
    this.competitionService = competitionService;
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping
  List<CompetitionResponse> getCompetitions() {
    return competitionService.getAllCompetitions();
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/{id}")
  public CompetitionResponse getCompetitionById(@PathVariable int id) {
    return competitionService.getCompetitionById(id);
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/type/{comp_type}")
  List<CompetitionResponse> getCompetitionsByCompType(@PathVariable String comp_type) {
    return competitionService.getCompetitionsByCompType(comp_type);
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @PostMapping
  CompetitionResponse addCompetition(@RequestBody CompetitionRequest body) {
    return competitionService.addCompetition(body);
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @DeleteMapping("/{id}")
  public void deleteCompetitionById(@PathVariable int id) {
    competitionService.deleteCompetitionById(id);
  }
}
