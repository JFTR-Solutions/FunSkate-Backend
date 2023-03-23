package com.example.funskatebackend.funskate.dto.skategroup;

import com.example.funskatebackend.funskate.entity.SkateGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SkateGroupResponse {
    private int id;
    private String name;
    private int clubMark;
    private int minAge;
    private int maxAge;

    public SkateGroupResponse(SkateGroup g) {
        this.id = g.getId();
        this.name = g.getName();
        this.clubMark = g.getClubMark();
        this.minAge = g.getMinAge();
        this.maxAge = g.getMaxAge();
    }
}
