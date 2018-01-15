package com.reverside.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reverside.auth.model.Employee;

public interface UserRepository extends JpaRepository<Employee, Long> {
    Employee findByUsername(String username);
}
