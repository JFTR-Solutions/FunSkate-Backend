package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.athlete.AthleteRequest;
import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.service.AthleteService;
import com.example.funskatebackend.funskate.service.ClubService;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<AthleteResponse>> getAthletes() {
        List<AthleteResponse> athletes = athleteService.getAthletes();

        CacheControl cacheControl = CacheControl.noCache()
                .noStore()
                .mustRevalidate()
                .sMaxAge(0, TimeUnit.SECONDS);

        return ResponseEntity.ok()
                .cacheControl(cacheControl)
                .body(athletes);
    }

    @GetMapping(path= "/{id}")
    AthleteResponse getAthlete(@PathVariable int id) {
        return athleteService.getAthlete(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @PostMapping
    AthleteResponse addAthlete(@RequestBody AthleteRequest athleteRequest) {
        return athleteService.addAthlete(athleteRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
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