package com.example.funskatebackend.funskate.service;


import com.example.funskatebackend.funskate.dto.club.ClubRequest;
import com.example.funskatebackend.funskate.dto.club.ClubResponse;
import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.entity.Location;
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

@Service
public class ClubService {
    ClubRepository clubRepository;

    UserWithRolesRepository userWithRolesRepository;

    public ClubService(ClubRepository clubRepository, UserWithRolesRepository userWithRolesRepository) {
        this.clubRepository = clubRepository;
        this.userWithRolesRepository = userWithRolesRepository;
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

    public int clubId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        UserWithRoles currentUser = userWithRolesRepository.findByUsername(currentUsername);

        if (currentUser.getRoles().contains(Role.ADMIN)) {
            throw new ResponseStatusException(HttpStatus.OK, "Admins do not have a club");
        }

        return currentUser.getClub().getId();

    }

    public ClubResponse getClubById(int id, boolean withAthletes, boolean withLocation) {
        Club club = clubRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Club not found"));
        return new ClubResponse(club, withAthletes, withLocation);
    }
}
