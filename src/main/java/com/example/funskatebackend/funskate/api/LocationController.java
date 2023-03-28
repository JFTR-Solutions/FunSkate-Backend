package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.location.LocationRequest;
import com.example.funskatebackend.funskate.dto.location.LocationResponse;
import com.example.funskatebackend.funskate.entity.Location;
import com.example.funskatebackend.funskate.service.LocationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("locations")
public class LocationController {

  LocationService locationService;

  public LocationController(LocationService locationService) {
    this.locationService = locationService;
  }

  @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
  @GetMapping
  List<LocationResponse> getLocations() {
    return locationService.getAllLocations();
  }

  @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
  @GetMapping("/{id}")
  public Optional<Location> getLocationById(@PathVariable int id) {
    return locationService.getLocationById(id);
  }

  @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
  @PostMapping
  LocationResponse addLocation(@RequestBody LocationRequest body) {
    return locationService.addLocation(body);
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @DeleteMapping("/{id}")
  public void deleteLocationById(@PathVariable int id) {
    locationService.deleteLocationById(id);
  }
}
