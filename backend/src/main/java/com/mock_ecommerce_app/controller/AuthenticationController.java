package com.mock_ecommerce_app.controller;

import com.mock_ecommerce_app.auth.AuthenticationRequest;
import com.mock_ecommerce_app.auth.RegisterRequest;
import com.mock_ecommerce_app.auth.AuthenticationResponse;
import com.mock_ecommerce_app.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterRequest request) {
        System.out.println(request);
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

//    @PostMapping("/register")
//    public ResponseEntity<UserDetails> registerUser(@RequestBody RegisterRequest request) {
//        Authentication authentication = authenticationService.register(request);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        System.out.println(userDetails.getAuthorities());
//
//        return ResponseEntity.ok(userDetails);
//    }
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<UserDetails> authenticateUser(@RequestBody AuthenticationRequest request) {
////        return ResponseEntity.ok(authenticationService.authenticate(request));
//        Authentication authentication = authenticationService.authenticate(request);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        System.out.println(userDetails.getAuthorities());
//
//
//        return ResponseEntity.ok(userDetails);
//    }



}
