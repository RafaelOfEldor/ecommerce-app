package com.mock_ecommerce_app.service;

import com.mock_ecommerce_app.auth.AuthenticationRequest;
import com.mock_ecommerce_app.auth.AuthenticationResponse;
import com.mock_ecommerce_app.auth.RegisterRequest;
import com.mock_ecommerce_app.model.Role;
import com.mock_ecommerce_app.model.User;
import com.mock_ecommerce_app.model.UserCart;
import com.mock_ecommerce_app.repository.UserCartRepository;
import com.mock_ecommerce_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final UserCartRepository userCartRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
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
        return AuthenticationResponse.builder().token(jwtToken).build();
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

//    public Authentication register(RegisterRequest request) {
//        var user = User.builder()
//                .firstName(request.getFirstname())
//                .lastName(request.getLastname())
//                .email(request.getEmail())
//                .username(request.getUsername())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .role(Role.USER)
//                .build();
//        userRepository.save(user);
//        var jwtToken = jwtService.generateToken(user);
//        System.out.println(AuthenticationResponse.builder().token(jwtToken).build());
//        return authenticate(new AuthenticationRequest(request.getUsername(), request.getPassword()));
//    }
//
//    public Authentication authenticate(AuthenticationRequest request) {
//       Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getUsername(),
//                        request.getPassword()
//                )
//        );
//        var user = userRepository.findByUsername(request.getUsername())
//                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
//        var jwtToken = jwtService.generateToken(user);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
////        return AuthenticationResponse.builder().token(jwtToken).build();
//        return authentication;
//    }
}
