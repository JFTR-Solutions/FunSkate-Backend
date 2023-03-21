package com.example.funskatebackend.funskate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "clubmark", nullable = false, length = 255)
    private int clubMark;

    @Column(name = "min_age", nullable = false)
    private int minAge;

    @Column(name = "max_age", nullable = false)
    private int maxAge;

    public Group(int id, String name, int clubMark, int minAge, int maxAge) {
        this.id = id;
        this.name = name;
        this.clubMark = clubMark;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

}