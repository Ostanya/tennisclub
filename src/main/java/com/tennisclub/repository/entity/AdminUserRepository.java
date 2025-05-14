package com.tennisclub.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdminUserRepository extends JpaRepository<Admin, UUID> {

    Optional<Admin> findByUsername(String username);
}

