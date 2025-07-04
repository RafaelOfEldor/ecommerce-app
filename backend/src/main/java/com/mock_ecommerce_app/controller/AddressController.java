package com.mock_ecommerce_app.controller;

import com.mock_ecommerce_app.dtos.NewAddressDTO;
import com.mock_ecommerce_app.model.Address;
import com.mock_ecommerce_app.model.User;
import com.mock_ecommerce_app.service.AddressService;
import com.mock_ecommerce_app.service.ItemService;
import com.mock_ecommerce_app.service.OrderService;
import com.mock_ecommerce_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final ItemService itemService;
    private final AddressService addressService;
    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public AddressController(AddressService addressService, OrderService orderService, ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.addressService = addressService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping
    public List<Address> getAddresses() {
        return addressService.getAddresses();
    }

    @GetMapping("/page/{pageNumber}")
    public List<Address> getAddressesByPage(@PathVariable int pageNumber) {
        return addressService.getAddressesPageable(pageNumber);
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping
    public ResponseEntity<Optional<Address>> addAddress(@RequestBody NewAddressDTO newAddressDTO) {
        try {
            return addressService.createNewAddress(newAddressDTO);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Address updateAddressNyId(@PathVariable Long id, @RequestBody Address address) {
        try {
            return addressService.updateAddress(id, address);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        try {
            Address address = addressService.getAddressById(id);
            for (User user : address.getUsers()) {
                user.getAddresses().remove(address);
                address.setUsers(null);
            }
            addressService.deleteAddress(id);
        } catch (Exception e) {

        }
    }
}
