package com.example.funskatebackend.funskate.repository;

import com.example.funskatebackend.funskate.entity.EventParticipantGroup;
import com.example.funskatebackend.funskate.entity.MyKeyEventParticipantGroup;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface EventParticipantGroupRepository extends JpaRepository<EventParticipantGroup, MyKeyEventParticipantGroup> {

}
