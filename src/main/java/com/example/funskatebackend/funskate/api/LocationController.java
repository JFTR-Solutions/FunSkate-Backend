package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.location.LocationRequest;
import com.example.funskatebackend.funskate.dto.location.LocationResponse;
import com.example.funskatebackend.funskate.entity.Location;
import com.example.funskatebackend.funskate.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

  @GetMapping("/{id}")
  public Optional<Location> getLocationById(@PathVariable int id) {
    return locationService.getLocationById(id);
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
