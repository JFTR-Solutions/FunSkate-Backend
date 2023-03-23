package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.dto.athlete.AthleteRequest;
import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.repository.AthleteRepository;
import com.example.funskatebackend.funskate.repository.ClubRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AthleteService {

  AthleteRepository athleteRepository;
  ClubRepository clubRepository;

  public AthleteService(AthleteRepository athleteRepository) {
    this.athleteRepository = athleteRepository;
  }

  public AthleteResponse addAthlete(AthleteRequest athleteRequest) {

    //TODO Add check if athlete exists
   /*     if (athleteRepository.existsById(athleteRequest.getFirstName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Athlete with this ID already exist");
        }*/


    Athlete newAthlete = athleteRequest.getAthleteEntity(athleteRequest);
    newAthlete = athleteRepository.save(newAthlete);
    return new AthleteResponse(newAthlete, false, false);
  }

  public List<AthleteResponse> getAthletes() {
    List<Athlete> athletes = athleteRepository.findAll();

    //return athletes.stream().map(AthleteResponse::new).toList();
    return athletes.stream().map(athlete -> new AthleteResponse(athlete, true, false)).toList();
  }

  public AthleteResponse getAthlete(int id) {
    Athlete athlete = athleteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Athlete not found"));
    return new AthleteResponse(athlete, true, true);
  }


  public AthleteResponse updateAthlete(int id, AthleteRequest athleteRequest) {
    Athlete athlete = athleteRepository.findById(id).orElseThrow(()
        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Athlete not found"));
    athlete.setBirthdate(athleteRequest.getBirthdate());
    athlete.setFirstName(athleteRequest.getFirstName());
    athlete.setLastName(athleteRequest.getLastName());
    athlete.setClubMark(athleteRequest.getClubMark());
    athlete.setCompetitionNumber(athleteRequest.getCompetitionNumber());
    Club club = clubRepository.findById(athleteRequest.getClub().getId()).orElseThrow(()
        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Club not found"));
    athlete.setClub(club);
    athleteRepository.save(athlete);
    return new AthleteResponse(athlete, false, false);
  }

  public void deleteAthlete(int id) {
    athleteRepository.deleteById(id);
  }
}
