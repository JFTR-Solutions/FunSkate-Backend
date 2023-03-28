package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantRequest;
import com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantResponse;
import com.example.funskatebackend.funskate.entity.Athlete;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.EventParticipant;
import com.example.funskatebackend.funskate.service.EventParticipantService;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.funskatebackend.funskate.dto.eventparticipant.EventParticipantRequest.getEventParticipantEntity;

@RestController
@CrossOrigin
@RequestMapping("event-participant")
public class EventParticipantController {

  EventParticipantService eventParticipantService;

  public EventParticipantController(EventParticipantService eventParticipantService) {
    this.eventParticipantService = eventParticipantService;
  }

  @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
  @GetMapping("/{id}")
  public List<EventParticipantResponse> getAllParticipantsForEventByEventId(@PathVariable int id) {
    return eventParticipantService.getAllParticipantsForEventByEventId(id);
  }

  @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
  @PostMapping
  EventParticipantResponse addParticipantToEvent(@RequestBody EventParticipantRequest eventParticipantRequest) {
    return eventParticipantService.addEventParticipant(eventParticipantRequest);
  }

  @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
  @DeleteMapping("/delete/{compId}-{partId}")
  @Transactional
  public void deleteParticipant(@PathVariable int compId,@PathVariable int partId) {
    eventParticipantService.deleteParticipant(compId, partId);
  }
}
