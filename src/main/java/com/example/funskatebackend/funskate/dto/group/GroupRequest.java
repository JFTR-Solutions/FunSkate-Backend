package com.example.funskatebackend.funskate.dto.group;

import com.example.funskatebackend.funskate.entity.SkateGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GroupRequest {
    private String name;
    private int clubMark;
    private int minAge;
    private int maxAge;

    public static SkateGroup getGroupEntity(GroupRequest a){
        return new SkateGroup(a.name,a.clubMark, a.minAge,a.maxAge);
    }

    public GroupRequest (SkateGroup g){
        this.name = g.getName();
        this.clubMark = g.getClubMark();
        this.minAge = g.getMinAge();
        this.maxAge = g.getMaxAge();
    }

}
