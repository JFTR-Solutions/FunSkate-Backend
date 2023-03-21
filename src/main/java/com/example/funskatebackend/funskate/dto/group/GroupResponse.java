package com.example.funskatebackend.funskate.dto.group;

import com.example.funskatebackend.funskate.entity.SkateGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GroupResponse {

    private int id;
    private String firstName;
    private int clubMark;
    private int minAge;
    private int maxAge;

    public GroupResponse(SkateGroup g) {
        this.id = g.getId();
        this.firstName = g.getName();
        this.clubMark = g.getClubMark();
        this.minAge = g.getMinAge();
        this.maxAge = g.getMaxAge();
    }
}
