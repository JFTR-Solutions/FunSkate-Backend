package com.example.funskatebackend.security.repository;


import com.example.funskatebackend.security.entity.UserWithRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
UserWithRolesRepository extends JpaRepository<UserWithRoles,String> {
    Boolean existsByEmail(String email);

    UserWithRoles findByUsername(String username);
}
