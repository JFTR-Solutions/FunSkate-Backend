package com.example.funskatebackend.funskate.dto.athlete;

import com.example.funskatebackend.funskate.entity.Athlete;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class AthleteResponse {

    int id;
    String firstName;
    String lastName;
    LocalDate birthdate;
    LocalDate clubMark;
    int competitionNumber;

    public AthleteResponse(Athlete a) {
        this.id = a.getId();
        this.firstName = a.getFirstName();
        this.lastName = a.getLastName();
        this.birthdate = a.getBirthdate();
        this.clubMark = a.getClubMark();
        this.competitionNumber = a.getCompetitionNumber();
    }

}
