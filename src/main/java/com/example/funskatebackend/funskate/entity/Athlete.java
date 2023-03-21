package com.example.funskatebackend.funskate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "athlete")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthdate;

    @Column(name = "clubmark")
    private int clubMark;

    @Column(name = "competition_number")
    private int competitionNumber;

    //TODO ClubID


    public Athlete(String firstName, String lastName, LocalDate birthdate, int clubMark, int competitionNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.clubMark = clubMark;
        this.competitionNumber = competitionNumber;
    }
}
