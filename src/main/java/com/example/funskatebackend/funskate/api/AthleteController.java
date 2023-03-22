package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.athlete.AthleteRequest;
import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.service.AthleteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/athlete")
public class AthleteController {


    //Todo delete this comment
    AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
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