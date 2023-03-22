package com.example.funskatebackend.funskate.repository;

import com.example.funskatebackend.funskate.dto.competition.CompetitionResponse;
import com.example.funskatebackend.funskate.entity.Competition;
import com.example.funskatebackend.funskate.entity.CompetitionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Integer> {
  List<Competition> findAllByCompetitionType(CompetitionType compType);
}
