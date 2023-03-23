package com.example.funskatebackend.funskate.dto.club;

import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.CompetitionType;
import com.example.funskatebackend.funskate.entity.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClubRequest {

    private String name;
    private String logo;
    private Location location;
    private CompetitionType eastWest;

    public static Club getClubEntity(ClubRequest c) {
        return new Club(c.name, c.logo, c.location,c.eastWest);
    }

    public ClubRequest(Club c) {
        this.name = c.getName();
        this.logo = c.getLogo();
        this.location = c.getLocation();
        this.eastWest = c.getEastWest();
    }
}