package com.example.factory.controller;

import com.example.factory.dtos.ExistingAddressDTO;
import com.example.factory.dtos.NewAddressDTO;
import com.example.factory.model.*;
import com.example.factory.service.AddressService;
import com.example.factory.service.ItemService;
import com.example.factory.service.OrderService;
import com.example.factory.service.UserService;
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


    //Takes in id of user in parameter and a json body with Long field "addressId"
    //      {
    //          "addressId": 4 <-(number corresponding to address id)
    //      }
//    @PostMapping("/{id}/existingaddress")
//    public User  addExistingAddressToUser(@PathVariable Long id,  @RequestBody ExistingAddressDTO existingAddressDTO) {
//        try {
//            User user = userService.getUserById(id);
//            Address address = addressService.getAddressById(existingAddressDTO.getAddressId());
//            user.getAddresses().add(address);
//            return userService.addUser(user);
//        } catch (Exception e) {
//            return null;
//        }
//    }


    //Takes in id of user in api path and a body json with string field for addressStreetName and
    //string field for addressStreetNameNumber. Example:
    //      {
    //          "addressStreetName": "name of street",
    //          "addressStreetNameNumber": "id/number on house in the street"
    //      }
//    @PostMapping("/{id}/newaddress")
//    public User  createNewAddressAndAddItToUser(@PathVariable Long id,  @RequestBody NewAddressDTO newAddressDTO) {
//        try {
//            User user = userService.getUserById(id);
//            Address address = new Address(newAddressDTO.getAddressStreetName(), newAddressDTO.getAddressStreetNameNumber());
//            user.getAddresses().add(address);
//            return userService.addUser(user);
//        } catch (Exception e) {
//            return null;
//        }
//    }
}
