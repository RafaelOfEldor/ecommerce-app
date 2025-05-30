package com.mock_ecommerce_app.controller;

import com.mock_ecommerce_app.dtos.PurchaseItemDTO;
import com.mock_ecommerce_app.model.Order;
import com.mock_ecommerce_app.model.UserCart;
import com.mock_ecommerce_app.service.UserCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usercart")
@RequiredArgsConstructor
public class UserCartController {

    UserCartService userCartService;

    @Autowired
    public UserCartController(UserCartService userCartService) {
        this.userCartService = userCartService;
    }


    @GetMapping("/{userid}")
    public ResponseEntity<Optional<UserCart>> getCartByUserId(@PathVariable Long userid) {
        return userCartService.getCartByUserId(userid);
    }

    @PostMapping("/checkout")
    public ResponseEntity<Optional<Order>> confirmPurchase(@RequestBody PurchaseItemDTO purchaseItemDTO) {
        return userCartService.confirmPurchase(purchaseItemDTO);
    }
}
