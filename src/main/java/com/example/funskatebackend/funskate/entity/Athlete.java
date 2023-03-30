package com.example.funskatebackend.funskate.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "athlete")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Club club;

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<EventParticipant> eventParticipants;

    public Athlete(String firstName, String lastName, LocalDate birthdate, int clubMark, int competitionNumber, Club club) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.clubMark = clubMark;
        this.competitionNumber = competitionNumber;
        this.club = club;
    }

    public Athlete(int id, String firstName, String lastName, LocalDate birthdate, int clubMark, int competitionNumber, Club club) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.clubMark = clubMark;
        this.competitionNumber = competitionNumber;
        this.club = club;
    }
}