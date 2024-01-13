package com.example.factory.service;

import com.example.factory.controller.UserCartController;
import com.example.factory.dtos.UserIdDTO;
import com.example.factory.model.Customer;
import com.example.factory.model.User;
import com.example.factory.model.UserCart;
import com.example.factory.repository.UserCartRepository;
import com.example.factory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCartService {

    UserCartRepository userCartRepository;
    UserRepository userRepository;

    @Autowired
    public UserCartService(UserCartRepository userCartRepository, UserRepository userRepository) {
        this.userCartRepository = userCartRepository;
        this.userRepository = userRepository;
    }



    public List<UserCart> getUserCarts() {
        return userCartRepository.findAll();
    }

    public ResponseEntity<Optional<UserCart>> getCartByUserId(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            UserCart userCart = userCartRepository.findById(user.getUserCart().getId()).orElse(null);
            return ResponseEntity.ok(Optional.of(userCart));
        }
        return ResponseEntity.badRequest().body(Optional.of(null));
    }




    public UserCart getUserCartById(Long id) {
        return userCartRepository.findById(id).orElse(null);
    }
}
