package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.club.ClubResponse;
import com.example.funskatebackend.funskate.service.ClubService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/club")
public class ClubController {

    ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }



    @GetMapping
    public List<ClubResponse> getClubs(){
        return clubService.getClubs();
    }

}
