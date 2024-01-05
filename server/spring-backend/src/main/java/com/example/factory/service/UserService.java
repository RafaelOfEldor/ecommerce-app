package com.example.factory.service;

import com.example.factory.auth.RegisterRequest;
import com.example.factory.dtos.UserInfoDto;
import com.example.factory.model.User;
import com.example.factory.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User was not found"));
    }

    public UserInfoDto getUserInfoByUserName(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User was not found"));
        UserInfoDto userInfo= new UserInfoDto();
        userInfo.setUserName(user.getUserName());
        userInfo.setFirstName(user.getFirstName());
        userInfo.setLastName(user.getLastName());
        userInfo.setRole(user.getRole());
        userInfo.setEmail(user.getEmail());
        userInfo.setId(user.getId());
        return userInfo;
    }


//    public String findByUsername(String username) {
//        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
}
