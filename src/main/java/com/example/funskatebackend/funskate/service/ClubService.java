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
/*
    public ClubResponse addClub(ClubRequest clubRequest, Location location){
        Club newClub = ClubRequest.getClubEntity(clubRequest, location);
        newClub = clubRepository.save(newClub);
        return new ClubResponse(newClub);
    }

 */

  public List<ClubResponse> getClubs(boolean withAthletes, boolean withLocation) {
    List<Club> clubs = clubRepository.findAll();
    return clubs.stream().map(club -> new ClubResponse(club, withAthletes, withLocation)).toList();
  }

  public ClubResponse getClubById(int id, boolean withAthletes, boolean withLocation) {
    Club club = clubRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Club not found"));
    return new ClubResponse(club, withAthletes, withLocation);
  }
}
