package com.example.factory.controller;

import com.example.factory.dtos.UsernameDto;
import com.example.factory.model.User;
import com.example.factory.service.AuthenticationService;
import com.example.factory.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/userinfo")
    public ResponseEntity<User> getUserInfo(@RequestBody UsernameDto usernameDto) {

        /*
        Make a DTO that sends back firstName, lastName, username, role, email, id
        */
        User user = userService.findByUsername(usernameDto.getUsername());
        return ResponseEntity.ok(user);
    }
}
