package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.dto.athlete.AthleteRequest;
import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.repository.AthleteRepository;
import com.example.funskatebackend.funskate.repository.ClubRepository;
import com.example.funskatebackend.security.entity.Role;
import com.example.funskatebackend.security.entity.UserWithRoles;
import com.example.funskatebackend.security.repository.UserWithRolesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.funskatebackend.funskate.dto.athlete.AthleteRequest.getAthleteEntity;

@Service
public class AthleteService {

  AthleteRepository athleteRepository;
  ClubRepository clubRepository;
  UserWithRolesRepository userWithRolesRepository;

  public AthleteService(AthleteRepository athleteRepository,
                        UserWithRolesRepository userWithRolesRepository) {
    this.athleteRepository = athleteRepository;
    this.userWithRolesRepository = userWithRolesRepository;
  }

  public AthleteResponse addAthlete(AthleteRequest athleteRequest) {


    Athlete newAthlete = getAthleteEntity(athleteRequest);
    newAthlete = athleteRepository.save(newAthlete);
    return new AthleteResponse(newAthlete, false, false);
  }


  public List<AthleteResponse> getAthletes() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentUsername = authentication.getName();
    UserWithRoles currentUser = userWithRolesRepository.findByUsername(currentUsername);
    if (currentUser.getRoles().contains(Role.ADMIN)) {
      List<Athlete> athletes = athleteRepository.findAll();
      return athletes.stream().map(a -> new AthleteResponse(a, true, false)).collect(Collectors.toList());
    } else if (currentUser.getRoles().contains(Role.USER)) {
      Club currentClub = currentUser.getClub();
      List<Athlete> athletes = athleteRepository.findByClub(currentClub);
      return athletes.stream().map(a -> new AthleteResponse(a, true, false)).collect(Collectors.toList());
    } else {
      throw new IllegalStateException("Unknown user role: " + currentUser.getRoles());
    }
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
    athlete.setClub(athleteRequest.getClub());
    athleteRepository.save(athlete);
    return new AthleteResponse(athlete, false, false);
  }

  public void deleteAthlete(int id) {
    athleteRepository.deleteById(id);
  }
}
