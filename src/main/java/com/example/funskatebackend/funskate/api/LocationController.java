package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.competition.CompetitionRequest;
import com.example.funskatebackend.funskate.dto.competition.CompetitionResponse;
import com.example.funskatebackend.funskate.dto.location.LocationRequest;
import com.example.funskatebackend.funskate.dto.location.LocationResponse;
import com.example.funskatebackend.funskate.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/locations")
public class LocationController {

  LocationService locationService;

  public LocationController(LocationService locationService) {
    this.locationService = locationService;
  }

  @GetMapping
  List<LocationResponse> getLocations() {
    return locationService.getAllLocations();
  }

  @PostMapping
  LocationResponse addLocation(@RequestBody LocationRequest body) {
    return locationService.addLocation(body);
  }

  @DeleteMapping("/{id}")
  public void deleteLocationById(@PathVariable int id) {
    locationService.deleteLocationById(id);
  }
}
