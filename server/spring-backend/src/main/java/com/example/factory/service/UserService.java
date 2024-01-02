package com.example.factory.service;

import com.example.factory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public String findByUsername(String username) {
//        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
}
