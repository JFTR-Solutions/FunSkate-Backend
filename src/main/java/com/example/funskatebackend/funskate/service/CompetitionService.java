package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.dto.athlete.AthleteResponse;
import com.example.funskatebackend.funskate.dto.competition.CompetitionRequest;
import com.example.funskatebackend.funskate.dto.competition.CompetitionResponse;
import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.CompetitionType;
import com.example.funskatebackend.funskate.repository.AthleteRepository;
import com.example.funskatebackend.funskate.repository.CompetitionRepository;
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

@Service
public class CompetitionService {

    CompetitionRepository competitionRepository;
    UserWithRolesRepository userWithRolesRepository;
    AthleteRepository athleteRepository;

    public CompetitionService(CompetitionRepository competitionRepository, UserWithRolesRepository userWithRolesRepository, AthleteRepository athleteRepository) {
        this.competitionRepository = competitionRepository;
        this.userWithRolesRepository = userWithRolesRepository;
        this.athleteRepository = athleteRepository;
    }

    public List<CompetitionResponse> getAllCompetitions() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        UserWithRoles currentUser = userWithRolesRepository.findByUsername(currentUsername);

        List<Competition> competitions = competitionRepository.findAll();

        if (currentUser.getRoles().contains(Role.ADMIN)) {
            return competitions.stream().map(a -> new CompetitionResponse(a, false)).collect(Collectors.toList());
        }
        Club currentClub = currentUser.getClub();
        if (currentClub.getEastWest() == CompetitionType.WEST) {
            return competitions.stream().filter(a -> a.getCompetitionType() != CompetitionType.EAST).map(a -> new CompetitionResponse(a, false)).collect(Collectors.toList());
        } else if (currentClub.getEastWest() == CompetitionType.EAST) {
            return competitions.stream().filter(a -> a.getCompetitionType() != CompetitionType.WEST).map(a -> new CompetitionResponse(a, false)).collect(Collectors.toList());
        }
        else {
            return competitions.stream().map(a -> new CompetitionResponse(a, false)).collect(Collectors.toList());
        }
    }


    public CompetitionResponse addCompetition(CompetitionRequest competitionRequest) {
        Competition newCompetition = CompetitionRequest.getCompetitionEntity(competitionRequest);
        newCompetition = competitionRepository.save(newCompetition);

        return new CompetitionResponse(newCompetition, false);
    }

    public void deleteCompetitionById(int id) {
        competitionRepository.deleteById(id);
    }

    public List<CompetitionResponse> getCompetitionsByCompType(String compType) {
        List<Competition> competitions = competitionRepository.findAllByCompetitionType(CompetitionType.valueOf(compType));
        return competitions.stream().map(competition -> new CompetitionResponse(competition, true)).toList();
    }

    public CompetitionResponse getCompetitionById(int id) {
        Competition competition = competitionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competition not found"));
        return new CompetitionResponse(competition, true);
    }
}
