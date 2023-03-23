package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.athlete.AthleteRequest;
import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.service.AthleteService;
import com.example.funskatebackend.funskate.service.ClubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("athletes")
public class AthleteController {


    //Todo delete this comment
    AthleteService athleteService;
    ClubService clubService;

    public AthleteController(AthleteService athleteService, ClubService clubService) {
        this.athleteService = athleteService;
        this.clubService = clubService;
    }

    @GetMapping
    List<AthleteResponse> getAthletes() {
        return athleteService.getAthletes();
    }

    @GetMapping(path= "/{id}")
    AthleteResponse getAthlete(@PathVariable int id) {
        return athleteService.getAthlete(id);
    }

    @PostMapping
    AthleteResponse addAthlete(@RequestBody AthleteRequest athleteRequest) {
        return athleteService.addAthlete(athleteRequest);
    }

    @PutMapping(path = "/{id}")
    AthleteResponse updateAthlete(@PathVariable int id, @RequestBody AthleteRequest athleteRequest) {
        return athleteService.updateAthlete(id, athleteRequest);
    }

    @DeleteMapping(path = "/{id}")
    void deleteAthlete(@PathVariable int id) {
        athleteService.deleteAthlete(id);
    }

}