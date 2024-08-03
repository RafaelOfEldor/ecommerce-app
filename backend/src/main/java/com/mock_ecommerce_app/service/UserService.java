package com.mock_ecommerce_app.service;

import com.mock_ecommerce_app.dtos.AddToCartDTO;
import com.mock_ecommerce_app.dtos.UserChangeDTO;
import com.mock_ecommerce_app.dtos.UserInfoDto;
import com.mock_ecommerce_app.model.Item;
import com.mock_ecommerce_app.model.User;
import com.mock_ecommerce_app.model.UserCart;
import com.mock_ecommerce_app.repository.ItemRepository;
import com.mock_ecommerce_app.repository.UserCartRepository;
import com.mock_ecommerce_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserCartRepository userCartRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserCartRepository userCartRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.userCartRepository = userCartRepository;
        this.itemRepository = itemRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User was not found"));
    }



    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public ResponseEntity<Optional<UserCart>> addItemToCart(AddToCartDTO addToCartDTO) {
        try {
            User user = userRepository.findById(addToCartDTO.getUserId()).orElse(null);
            if (user != null) {
                UserCart userCart = userCartRepository.findById(user.getUserCart().getId()).orElse(null);
                Item item = itemRepository.findById(addToCartDTO.getItemId()).orElse(null);
                userCart.getItems().add(item);
                userCartRepository.save(userCart);
                userRepository.save(user);
                return ResponseEntity.ok(Optional.of(userCart));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.badRequest().body(null);
    }

    public ResponseEntity<Optional<UserCart>> removeItemFromCart(AddToCartDTO addToCartDTO) {
        try {
            User user = userRepository.findById(addToCartDTO.getUserId()).orElse(null);
            if (user != null) {
                UserCart userCart = userCartRepository.findById(user.getUserCart().getId()).orElse(null);
                Item item = itemRepository.findById(addToCartDTO.getItemId()).orElse(null);
                userCart.getItems().remove(item);
                userCartRepository.save(userCart);
                userRepository.save(user);
                return ResponseEntity.ok(Optional.of(userCart));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.badRequest().body(null);
    }



    public ResponseEntity<Optional<UserInfoDto>> getUserInfoByUserName(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {

        UserInfoDto userInfo= new UserInfoDto();
        userInfo.setUserName(user.getUserName());
        userInfo.setFirstName(user.getFirstname());
        userInfo.setLastName(user.getLastname());
        userInfo.setAddresses(user.getAddresses());
        userInfo.setOrders(user.getOrders());
        userInfo.setRole(user.getRole());
        userInfo.setEmail(user.getEmail());
        userInfo.setId(user.getId());
        userInfo.setUserCart(user.getUserCart());
        return ResponseEntity.ok(Optional.of(userInfo));
        }
        return ResponseEntity.badRequest().body(null);
    }


    public ResponseEntity<String> changeFirstname(UserChangeDTO firstnameRequest) {
        User user = userRepository.findByUsername(firstnameRequest.getUsername()).orElse(null);
        if (user != null) {
            System.out.println("in here");
            user.setFirstname(firstnameRequest.getDetailToChange());
            userRepository.save(user);
            return ResponseEntity.ok("Change was successfully made");
        }
            System.out.println("out here");
        return ResponseEntity.badRequest().body("Couldn't change first name :/");
    }

    public ResponseEntity<String> changeLastname(UserChangeDTO lastnameRequest) {
        User user = userRepository.findByUsername(lastnameRequest.getUsername()).orElse(null);
        if (user != null) {
            user.setLastname(lastnameRequest.getDetailToChange());
            userRepository.save(user);
            return ResponseEntity.ok("Change was successfully made");
        }
        return ResponseEntity.badRequest().body("Couldn't change last name :/");
    }

    public ResponseEntity<String> changeUsername(UserChangeDTO usernameRequest) {
        User user = userRepository.findByUsername(usernameRequest.getUsername()).orElse(null);

        if (!userRepository.findByUsername(usernameRequest.getDetailToChange()).isEmpty()) {
            return ResponseEntity.badRequest().body("username is already taken");
        }

        if (user != null && userRepository.findByUsername(usernameRequest.getDetailToChange()).isEmpty()) {
            user.setUserName(usernameRequest.getDetailToChange());
            userRepository.save(user);
            return ResponseEntity.ok("Change was successfully made");
        }

        return ResponseEntity.badRequest().body("Couldn't change username :/");
    }

    public ResponseEntity<String> changeEmail(UserChangeDTO emailRequest) {
        User user = userRepository.findByUsername(emailRequest.getUsername()).orElse(null);
        if (user != null) {
            user.setEmail(emailRequest.getDetailToChange());
            userRepository.save(user);
            return ResponseEntity.ok("Change was successfully made");
        }
        return ResponseEntity.badRequest().body("Couldn't change email :/");
    }


//    public String findByUsername(String username) {
//        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
}
