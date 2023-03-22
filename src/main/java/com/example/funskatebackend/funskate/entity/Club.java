package com.example.funskatebackend.funskate.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "logo", nullable = false)
    private String logo;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<Athlete> athletes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @Enumerated(EnumType.STRING)
    @Column(name = "east_west")
    private CompetitionType eastWest;



    public Club(String name, String logo, Location location) {
        this.name = name;
        this.logo = logo;
        this.location = location;
    }

    public Club(String name, String logo, Location location, CompetitionType eastWest) {
        this.name = name;
        this.logo = logo;
        this.location = location;
        this.eastWest = eastWest;
    }
}
