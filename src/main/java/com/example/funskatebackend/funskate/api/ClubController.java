package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.dto.club.ClubResponse;
import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.service.ClubService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("clubs")
public class ClubController {

    ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping
    public List<ClubResponse> getClubs(){
        return clubService.getClubs(false, true);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ClubResponse getClubById(@PathVariable int id) {
        return clubService.getClubById(id, false, true);
    }


    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/clubid")
    public int getClubId() {
        return clubService.clubId();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/{id}/athletes")
    public List<AthleteResponse> getAthletesFromClub(@PathVariable int id) {
        ClubResponse club = clubService.getClubById(id, true, false);

        return club.getAthletes();
    }
}