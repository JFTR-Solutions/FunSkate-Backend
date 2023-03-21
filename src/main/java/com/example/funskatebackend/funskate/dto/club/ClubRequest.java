package com.example.funskatebackend.funskate.dto.club;

import com.example.funskatebackend.funskate.entity.Club;
import com.example.funskatebackend.funskate.entity.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClubRequest {

    private int id;
    private String name;
    private String logo;
    private Location location;

    public static Club getClubEntity(ClubRequest c, Location location) {
        return new Club(c.name, c.logo, location);
    }

    public ClubRequest(Club c) {
        this.id = c.getId();
        this.name = c.getName();
        this.logo = c.getLogo();
        this.location = c.getLocation();
    }
}