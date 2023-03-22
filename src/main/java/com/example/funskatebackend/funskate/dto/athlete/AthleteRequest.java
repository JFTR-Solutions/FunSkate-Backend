package com.example.funskatebackend.funskate.dto.athlete;

import com.example.funskatebackend.funskate.entity.Athlete;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AthleteRequest {

    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private int clubMark;
    private int competitionNumber;

    public static Athlete getAthleteEntity(AthleteRequest a){
        return new Athlete(a.firstName,a.lastName,a.birthdate, a.clubMark, a.competitionNumber);
    }

    public AthleteRequest (Athlete a){
        this.firstName = a.getFirstName();
        this.lastName = a.getLastName();
        this.birthdate = a.getBirthdate();
        this.clubMark = a.getClubMark();
        this.competitionNumber = a.getCompetitionNumber();
    }

}
