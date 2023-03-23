package com.example.funskatebackend.funskate.dto.athlete;

import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Club;
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
    private Club club;

    public static Athlete getAthleteEntity(AthleteRequest a){
        return new Athlete(a.firstName,a.lastName,a.birthdate, a.clubMark, a.competitionNumber, a.club);
    }

    public AthleteRequest (Athlete a){
        this.firstName = a.getFirstName();
        this.lastName = a.getLastName();
        this.birthdate = a.getBirthdate();
        this.clubMark = a.getClubMark();
        this.competitionNumber = a.getCompetitionNumber();
        this.club = a.getClub();
    }
}