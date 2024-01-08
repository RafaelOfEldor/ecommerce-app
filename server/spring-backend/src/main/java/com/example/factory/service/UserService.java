package com.example.factory.service;

import com.example.factory.auth.RegisterRequest;
import com.example.factory.dtos.UserChangeDTO;
import com.example.factory.dtos.UserInfoDto;
import com.example.factory.model.User;
import com.example.factory.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public ResponseEntity<Optional<UserInfoDto>> getUserInfoByUserName(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {

        UserInfoDto userInfo= new UserInfoDto();
        userInfo.setUserName(user.getUserName());
        userInfo.setFirstName(user.getFirstName());
        userInfo.setLastName(user.getLastName());
        userInfo.setRole(user.getRole());
        userInfo.setEmail(user.getEmail());
        userInfo.setId(user.getId());
        return ResponseEntity.ok(Optional.of(userInfo));
        }
        return ResponseEntity.badRequest().body(null);
    }

    public ResponseEntity<String> changeFirstname(UserChangeDTO firstnameRequest) {
        User user = userRepository.findByUsername(firstnameRequest.getUsername()).orElse(null);
        if (user != null) {
            System.out.println("in here");
            user.setFirstName(firstnameRequest.getDetailToChange());
            userRepository.save(user);
            return ResponseEntity.ok("Change was successfully made");
        }
            System.out.println("out here");
        return ResponseEntity.badRequest().body("Couldn't change first name :/");
    }

    public ResponseEntity<String> changeLastname(UserChangeDTO lastnameRequest) {
        User user = userRepository.findByUsername(lastnameRequest.getUsername()).orElse(null);
        if (user != null) {
            user.setLastName(lastnameRequest.getDetailToChange());
            userRepository.save(user);
            return ResponseEntity.ok("Change was successfully made");
        }
        return ResponseEntity.badRequest().body("Couldn't change last name :/");
    }

    public ResponseEntity<String> changeUsername(UserChangeDTO usernameRequest) {
        User user = userRepository.findByUsername(usernameRequest.getUsername()).orElse(null);

        if (!userRepository.findByUsername(usernameRequest.getDetailToChange()).isEmpty()) {
            return ResponseEntity.badRequest().body("username is already taken");
        }

        if (user != null && userRepository.findByUsername(usernameRequest.getDetailToChange()).isEmpty()) {
            user.setUserName(usernameRequest.getDetailToChange());
            userRepository.save(user);
            return ResponseEntity.ok("Change was successfully made");
        }

        return ResponseEntity.badRequest().body("Couldn't change username :/");
    }

    public ResponseEntity<String> changeEmail(UserChangeDTO emailRequest) {
        User user = userRepository.findByUsername(emailRequest.getUsername()).orElse(null);
        if (user != null) {
            user.setEmail(emailRequest.getDetailToChange());
            userRepository.save(user);
            return ResponseEntity.ok("Change was successfully made");
        }
        return ResponseEntity.badRequest().body("Couldn't change email :/");
    }


//    public String findByUsername(String username) {
//        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
}
