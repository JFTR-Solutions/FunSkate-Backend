package com.example.funskatebackend.funskate.dto.club;

import com.example.funskatebackend.funskate.entity.Club;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClubResponse {

    private int id;
    private String name;
    private String logo;

    public ClubResponse(Club c) {
        this.id = c.getId();
        this.name = c.getName();
        this.logo = c.getLogo();

    }
}

