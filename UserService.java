package com.reverside.auth.service;

import com.reverside.auth.model.Employee;

public interface UserService {
    void save(Employee employee);

    Employee findByUsername(String username, String email);
}
