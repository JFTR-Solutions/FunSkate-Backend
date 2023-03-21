package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.dto.athlete.AthleteRequest;
import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.repository.AthleteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AthleteService {

AthleteRepository athleteRepository;

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
        return new AthleteResponse(newAthlete);
    }

    public List<AthleteResponse> getAthletes(){
        List<Athlete> athletes = athleteRepository.findAll();

        return athletes.stream().map(a -> new AthleteResponse(a)).toList();

    }


}
