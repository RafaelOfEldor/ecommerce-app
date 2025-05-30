package com.mock_ecommerce_app.controller;

import com.mock_ecommerce_app.auth.AuthenticationRequest;
import com.mock_ecommerce_app.auth.RegisterRequest;
import com.mock_ecommerce_app.auth.AuthenticationResponse;
import com.mock_ecommerce_app.dtos.OpenIdCredentialsDTO;
import com.mock_ecommerce_app.service.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Optional<AuthenticationResponse>> registerUser(@RequestBody RegisterRequest request) {
        return authenticationService.register(request);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/login/credentials")
    public ResponseEntity<OpenIdCredentialsDTO> getCredentials() {
        return ResponseEntity.ok(authenticationService.getCredentials());
    }

    @PostMapping("/login/accessToken")
    public ResponseEntity<Void> setAccessToken(@RequestBody Map<String, String> body, HttpServletResponse response) {
        try {
            String accessToken = body.get("access_token");
            if (accessToken == null) {
                return ResponseEntity.badRequest().build();
            }
            authenticationService.setAccessToken(accessToken, response);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/login/google")
    public ResponseEntity<AuthenticationResponse> googleLogin(@RequestBody Map<String, String> body) {
        try {
            String accessToken = body.get("access_token");
            if (accessToken == null) {
                return ResponseEntity.badRequest().build();
            }
            AuthenticationResponse response = authenticationService.authenticateWithGoogle(accessToken);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

