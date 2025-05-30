package com.mock_ecommerce_app.controller;

import com.mock_ecommerce_app.dtos.AddToCartDTO;
import com.mock_ecommerce_app.dtos.UserChangeDTO;
import com.mock_ecommerce_app.dtos.UserInfoDto;
import com.mock_ecommerce_app.dtos.UsernameDto;
import com.mock_ecommerce_app.model.UserCart;
import com.mock_ecommerce_app.service.UserService;
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

    @PostMapping("/cart/additem")
    public ResponseEntity<Optional<UserCart>> addItemToCart(@RequestBody AddToCartDTO addToCartDTO) {
        ResponseEntity<Optional<UserCart>> UserCart = userService.addItemToCart(addToCartDTO);
        if (UserCart == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return UserCart;
    }

    @PostMapping("/cart/removeitem")
    public ResponseEntity<Optional<UserCart>> removeItemFromCart(@RequestBody AddToCartDTO addToCartDTO) {
        ResponseEntity<Optional<UserCart>> UserCart = userService.removeItemFromCart(addToCartDTO);
        if (UserCart == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return UserCart;
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
