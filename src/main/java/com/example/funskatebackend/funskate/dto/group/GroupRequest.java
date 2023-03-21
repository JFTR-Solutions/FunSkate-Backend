package com.example.funskatebackend.funskate.dto.group;

import com.example.funskatebackend.funskate.dto.athlete.AthleteRequest;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Group;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GroupRequest {

    private int id;
    private String name;
    private int clubMark;
    private int minAge;
    private int maxAge;

    public static Group getGroupEntity(GroupRequest a){
        return new Group(a.id,a.name,a.clubMark, a.minAge,a.maxAge);
    }

    public GroupRequest (Group g){
        this.id = g.getId();
        this.name = g.getName();
        this.clubMark = g.getClubMark();
        this.minAge = g.getMinAge();
        this.maxAge = g.getMaxAge();
    }

}
