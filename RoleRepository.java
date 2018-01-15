package com.reverside.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reverside.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
