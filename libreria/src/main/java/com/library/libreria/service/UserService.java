package com.library.libreria.service;

import com.library.libreria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        var userEntity = userRepo.findByUser(userName).orElseThrow(() -> new UsernameNotFoundException("Usuario " + userName + " no encontrado"));
        return User.builder()
                .username(userEntity.getUserName())
                .password(userEntity.getPassword())
                .roles("USER")
                .build();
    }
}
