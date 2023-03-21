package com.example.funskatebackend.funskate.dto.club;

import com.example.funskatebackend.funskate.entity.Club;
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


    public static Club getClubEntity(ClubRequest c) {
        return new Club(c.id, c.name, c.logo);
    }

    public ClubRequest(Club c) {
        this.id = c.getId();
        this.name = c.getName();
        this.logo = c.getLogo();
    }
}