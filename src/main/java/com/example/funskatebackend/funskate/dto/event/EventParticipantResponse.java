package com.example.funskatebackend.funskate.dto.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventParticipantResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private int clubMark;
}
