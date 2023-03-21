package com.example.funskatebackend.funskate.repository;

import com.example.funskatebackend.funskate.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, String> {

}
