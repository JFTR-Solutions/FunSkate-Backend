package com.example.funskatebackend.funskate.repository;

import com.example.funskatebackend.funskate.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {

}
