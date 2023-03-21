package com.example.funskatebackend.funskate.service;


import com.example.funskatebackend.funskate.dto.club.ClubRequest;
import com.example.funskatebackend.funskate.dto.club.ClubResponse;
import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubService {
    ClubRepository clubRepository;
    ClubService clubService;

    public ClubService(ClubService clubService) {
        this.clubService = clubService;
    }

    public ClubResponse addClub(ClubRequest clubRequest){
        Club newClub = ClubRequest.getClubEntity(clubRequest);
        newClub = clubRepository.save(newClub);
        return new ClubResponse(newClub);
    }

    public List<ClubResponse> getClubs(){
        List<Club> clubs = clubRepository.findAll();
         return clubs.stream().map(ClubResponse::new).toList();
    }


}