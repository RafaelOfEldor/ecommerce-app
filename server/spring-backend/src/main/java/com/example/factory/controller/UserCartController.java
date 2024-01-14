package com.example.factory.controller;

import com.example.factory.dtos.AddToCartDTO;
import com.example.factory.dtos.PurchaseItemDTO;
import com.example.factory.dtos.UserIdDTO;
import com.example.factory.model.Order;
import com.example.factory.model.OrderedItem;
import com.example.factory.model.UserCart;
import com.example.factory.service.UserCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/checkout")
    public ResponseEntity<Optional<Order>> confirmPurchase(@RequestBody PurchaseItemDTO purchaseItemDTO) {
        return userCartService.confirmPurchase(purchaseItemDTO);
    }
}
