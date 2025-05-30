package com.mock_ecommerce_app.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import com.mock_ecommerce_app.auth.AuthenticationRequest;
import com.mock_ecommerce_app.auth.AuthenticationResponse;
import com.mock_ecommerce_app.auth.RegisterRequest;
import com.mock_ecommerce_app.dtos.OpenIdCredentialsDTO;
import com.mock_ecommerce_app.model.Role;
import com.mock_ecommerce_app.model.User;
import com.mock_ecommerce_app.model.UserCart;
import com.mock_ecommerce_app.repository.UserCartRepository;
import com.mock_ecommerce_app.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final UserCartRepository userCartRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Value("${GOOGLE_DISCOVERY_URL}")
    private String googleDiscoveryUrl;

    @Value("${GOOGLE_CLIENT_ID}")
    private String googleClientId;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ResponseEntity<Optional<AuthenticationResponse>> register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }
        UserCart userCart = new UserCart();
        userCartRepository.save(userCart);
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .userCart(userCart)
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        userCart.setUser(user);
        userCartRepository.save(userCart);
        var jwtToken = jwtService.generateToken(user);
        userRepository.save(user);
        return ResponseEntity.ok(Optional.of(AuthenticationResponse.builder().token(jwtToken).build()));
    }

    public OpenIdCredentialsDTO getCredentials() {
        OpenIdCredentialsDTO credentials = new OpenIdCredentialsDTO();
        credentials.setGoogle_openid_config(googleDiscoveryUrl);
        credentials.setGoogle_client_id(googleClientId);
        return credentials;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public void setAccessToken(String accessToken, HttpServletResponse response) {
        Cookie cookie = createCookie("access_token", accessToken);
        response.addCookie(cookie);
    }

    private Cookie createCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24);
        return cookie;
    }

    public AuthenticationResponse authenticateWithGoogle(String accessToken) {
        String userInfoUrl = "https://www.googleapis.com/oauth2/v3/userinfo";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response = restTemplate.exchange(userInfoUrl, HttpMethod.GET, entity, String.class);

            JsonNode jsonNode = objectMapper.readTree(response.getBody());

            String email = jsonNode.get("email").asText();
            String userName = jsonNode.get("name").asText(); 
            String sub = jsonNode.get("sub").asText(); 

            User user = userRepository.findByUsername(userName + " " + sub).orElse(null);
            UserCart userCart = new UserCart();
            userCartRepository.save(userCart);

            if (user == null) {
                user = User.builder()
                        .firstname(jsonNode.get("given_name").asText())
                        .lastname(jsonNode.get("family_name").asText())
                        .email(email)
                        .userCart(userCart)
                        .username(userName + " " + sub)
                        .password(passwordEncoder.encode(generateRandomPassword())) 
                        .role(Role.USER)
                        .build();
                userRepository.save(user);
                userCart.setUser(user);
                userCartRepository.save(userCart);
                userRepository.save(user);
            }

            var jwtToken = jwtService.generateToken(user);


            return AuthenticationResponse.builder().token(jwtToken).build();
        } catch (Exception e) {
            throw new RuntimeException("Failed to authenticate with Google", e);
        }
    }

    private String generateRandomPassword() {
        return "temporaryPassword";
    }
}
