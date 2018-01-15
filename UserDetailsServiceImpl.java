package com.reverside.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reverside.auth.model.Role;
import com.reverside.auth.model.Employee;
import com.reverside.auth.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl<UserEmail> implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : employee.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(employee.getUsername(), employee.getPassword(), grantedAuthorities);
    }
    
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public UserEmail loadUserByUserEmail(String email) throws UsernameNotFoundException {
        Employee employee = userRepository.findByUsername(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : employee.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return (UserEmail) new org.springframework.security.core.userdetails.User(employee.getUsername(), employee.getPassword(), grantedAuthorities);
    }
}
