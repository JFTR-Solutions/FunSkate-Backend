package com.example.funskatebackend.funskate.repository;

import com.example.funskatebackend.funskate.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Integer> {


}
