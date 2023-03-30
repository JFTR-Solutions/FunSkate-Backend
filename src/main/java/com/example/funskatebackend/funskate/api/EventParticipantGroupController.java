package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.eventparticipantgroup.EventParticipantGroupRequest;
import com.example.funskatebackend.funskate.dto.eventparticipantgroup.EventParticipantGroupResponse;
import com.example.funskatebackend.funskate.service.EventParticipantGroupService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("event-participant-group")
public class EventParticipantGroupController {

  EventParticipantGroupService eventParticipantGroupService;

  public EventParticipantGroupController(EventParticipantGroupService eventParticipantGroupService) {
    this.eventParticipantGroupService = eventParticipantGroupService;
  }

  //@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
  @GetMapping
  List<EventParticipantGroupResponse> getAllEventParticipantsWithGroups() {
    return eventParticipantGroupService.getAllEventParticipantsWithGroups();
  }

  @PostMapping
  EventParticipantGroupResponse addEventPartGroups(@RequestBody EventParticipantGroupRequest eventParticipantGroupRequest) {
    //return eventParticipantGroupService.addEventParticipantGroups(eventParticipantGroupRequest);
    return null;
  }

  @GetMapping("/{id}")
  EventParticipantGroupResponse findEPGById(@PathVariable int id) {
    return null;
  }

  @DeleteMapping("/delete/{id}")
  @Transactional
  public void deleteParticipantGroups(@PathVariable int id) {
    eventParticipantGroupService.deleteParticipantGroups(id);
  }

}
