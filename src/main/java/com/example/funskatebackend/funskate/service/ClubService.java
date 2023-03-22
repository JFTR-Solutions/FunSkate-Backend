package com.example.funskatebackend.funskate.service;


import com.example.funskatebackend.funskate.dto.club.ClubRequest;
import com.example.funskatebackend.funskate.dto.club.ClubResponse;
import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.entity.Location;
import com.example.funskatebackend.funskate.repository.ClubRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClubService {
    ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public ClubResponse addClub(ClubRequest clubRequest, Location location){
        Club newClub = ClubRequest.getClubEntity(clubRequest, location);
        newClub = clubRepository.save(newClub);
        return new ClubResponse(newClub);
    }

    public List<ClubResponse> getClubs(){
        List<Club> clubs = clubRepository.findAll();
         return clubs.stream().map(ClubResponse::new).toList();
    }

    public ClubResponse getClub(int id){
        Club club = clubRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Club not found"));
        return new ClubResponse(club);
    }


}
