package com.example.funskatebackend.funskate.repository;

import com.example.funskatebackend.funskate.entity.SkateGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkateGroupRepository extends JpaRepository<SkateGroup, String> {

}
