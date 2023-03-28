package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.athlete.AthleteRequest;
import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.service.AthleteService;
import com.example.funskatebackend.funskate.service.ClubService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("athletes")
public class AthleteController {

    AthleteService athleteService;
    ClubService clubService;

    public AthleteController(AthleteService athleteService, ClubService clubService) {
        this.athleteService = athleteService;
        this.clubService = clubService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    List<AthleteResponse> getAthletes() {
        return athleteService.getAthletes();
    }

    @GetMapping(path= "/{id}")
    AthleteResponse getAthlete(@PathVariable int id) {
        return athleteService.getAthlete(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    AthleteResponse addAthlete(@RequestBody AthleteRequest athleteRequest) {
        return athleteService.addAthlete(athleteRequest);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(path = "/{id}")
    AthleteResponse updateAthlete(@PathVariable int id, @RequestBody AthleteRequest athleteRequest) {
        return athleteService.updateAthlete(id, athleteRequest);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(path = "/{id}")
    void deleteAthlete(@PathVariable int id) {
        athleteService.deleteAthlete(id);
    }

}