package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.dto.competition.CompetitionRequest;
import com.example.funskatebackend.funskate.dto.competition.CompetitionResponse;
import com.example.funskatebackend.funskate.dto.location.LocationRequest;
import com.example.funskatebackend.funskate.dto.location.LocationResponse;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.Location;
import com.example.funskatebackend.funskate.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

  LocationRepository locationRepository;

  public LocationService(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  public List<LocationResponse> getAllLocations() {
    List<Location> locations = locationRepository.findAll();

    return locations.stream().map(l -> new LocationResponse()).toList();
  }

  public LocationResponse addLocation(LocationRequest locationRequest) {
    Location newLocation = LocationRequest.getLocationEntity(locationRequest);
    newLocation = locationRepository.save(newLocation);

    return new LocationResponse(newLocation);
  }

  public void deleteLocationById(int id) {
  }
}
