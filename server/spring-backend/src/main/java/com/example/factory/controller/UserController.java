package com.example.factory.controller;

import com.example.factory.dtos.UserChangeDTO;
import com.example.factory.dtos.UserInfoDto;
import com.example.factory.dtos.UsernameDto;
import com.example.factory.model.User;
import com.example.factory.service.AuthenticationService;
import com.example.factory.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/userinfo")
    public ResponseEntity<Optional<UserInfoDto>> getUserInfo(@RequestBody UsernameDto usernameDto) {
        ResponseEntity<Optional<UserInfoDto>> user = userService.getUserInfoByUserName(usernameDto.getUsername());
        if (user == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return user;
    }

    @PostMapping("/change/firstname")
    public ResponseEntity<String> changeFirstname(@RequestBody UserChangeDTO firstnameRequest) {
        return userService.changeFirstname(firstnameRequest);
    }

    @PostMapping("/change/lastname")
    public ResponseEntity<String> changeLastname(@RequestBody UserChangeDTO lastnameRequest) {
        return userService.changeLastname(lastnameRequest);
    }

    @PostMapping("/change/username")
    public ResponseEntity<String> changeUsername(@RequestBody UserChangeDTO usernameRequest) {
        return userService.changeUsername(usernameRequest);
    }

    @PostMapping("/change/email")
    public ResponseEntity<String> changeEmail(@RequestBody UserChangeDTO emailRequest) {
        return userService.changeEmail(emailRequest);
    }
}
