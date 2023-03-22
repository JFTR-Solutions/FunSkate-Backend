package com.example.funskatebackend.funskate.repository;

import com.example.funskatebackend.funskate.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
