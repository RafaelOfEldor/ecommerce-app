package com.example.factory.service;

import com.example.factory.controller.UserCartController;
import com.example.factory.dtos.AddToCartDTO;
import com.example.factory.dtos.ItemsWithQuantityDTO;
import com.example.factory.dtos.PurchaseItemDTO;
import com.example.factory.dtos.UserIdDTO;
import com.example.factory.model.*;
import com.example.factory.repository.*;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCartService {

    UserCartRepository userCartRepository;
    UserRepository userRepository;
    ItemRepository itemRepository;
    OrderedItemRepository orderedItemRepository;
    OrderRepository orderRepository;
    AddressRepository addressRepository;

    @Autowired
    public UserCartService(UserCartRepository userCartRepository, UserRepository userRepository, ItemRepository itemRepository, OrderedItemRepository orderedItemRepository, OrderRepository orderRepository, AddressRepository addressRepository) {
        this.userCartRepository = userCartRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.orderedItemRepository = orderedItemRepository;
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
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

    public ResponseEntity<Optional<Order>> confirmPurchase(PurchaseItemDTO purchaseItemDTO) {
        try {
            User user = userRepository.findById(purchaseItemDTO.getUserId()).orElse(null);
            if (user != null) {
                UserCart userCart = userCartRepository.findById(user.getUserCart().getId()).orElse(null);
                Order order = orderRepository.save(new Order());
                for (ItemsWithQuantityDTO item : purchaseItemDTO.getItems()) {
                    OrderedItem orderedItem = orderedItemRepository.save(new OrderedItem(
                            item.getItemName(),
                            item.getItemOrigianlId(),
                            item.getItemImage(),
                            item.getItemPrice(),
                            item.getItemDescription(),
                            item.getItemCategory(),
                            item.getItemQuantity()
                    ));
                    Item itemToChange = itemRepository.findById(orderedItem.getOrderedItemOriginalItemId()).orElse(null);
                    if (itemToChange != null) {
                        itemToChange.setItemStock(itemToChange.getItemStock() - item.getItemQuantity());
                        itemRepository.save(itemToChange);
                        userCart.getItems().remove(itemToChange);
                        userCartRepository.save(userCart);
                    }
                    Address address = addressRepository.findById(purchaseItemDTO.getAddressId()).orElse(null);
                    order.setAddress(address);
                    order.setUser(user);
                    order.getItems().add(orderedItem);
                    user.getOrders().add(order);
                    orderRepository.save(order);
                    userRepository.save(user);
                }

                return ResponseEntity.ok(Optional.of(order));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.badRequest().body(null);
    }

    public UserCart getUserCartById(Long id) {
        return userCartRepository.findById(id).orElse(null);
    }
}
