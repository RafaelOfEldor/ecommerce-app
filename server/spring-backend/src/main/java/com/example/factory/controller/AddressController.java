package com.example.factory.controller;

import com.example.factory.dtos.ExistingAddressDTO;
import com.example.factory.dtos.NewAddressDTO;
import com.example.factory.model.*;
import com.example.factory.service.AddressService;
import com.example.factory.service.CustomerService;
import com.example.factory.service.ItemService;
import com.example.factory.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final CustomerService customerService;
    private final ItemService itemService;
    private final AddressService addressService;
    private final OrderService orderService;

    @Autowired
    public AddressController(CustomerService customerService, AddressService addressService, OrderService orderService, ItemService itemService) {
        this.customerService = customerService;
        this.itemService = itemService;
        this.addressService = addressService;
        this.orderService = orderService;
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
    public Address addAddress(@RequestBody Address newAddress) {
        try {
            Address address = addressService.addAddress(newAddress);
            for (Customer customer : newAddress.getCustomers()) {
                Customer newCustomer = customerService.getCustomerById(customer.getCustomerId());

                if (newCustomer != null) {
                    newCustomer.getAddresses().add(address);
                    customerService.addCustomer(newCustomer);
                }
            }
            return address;
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
            for (Customer customer : address.getCustomers()) {
                customer.getAddresses().remove(address);
                address.setCustomers(null);
            }
            addressService.deleteAddress(id);
        } catch (Exception e) {

        }
    }


    //Takes in id of customer in parameter and a json body with Long field "addressId"
    //      {
    //          "addressId": 4 <-(number corresponding to address id)
    //      }
    @PostMapping("/{id}/existingaddress")
    public Customer  addExistingAddressToCustomer(@PathVariable Long id,  @RequestBody ExistingAddressDTO existingAddressDTO) {
        try {
            Customer customer = customerService.getCustomerById(id);
            Address address = addressService.getAddressById(existingAddressDTO.getAddressId());
            customer.getAddresses().add(address);
            return customerService.addCustomer(customer);
        } catch (Exception e) {
            return null;
        }
    }


    //Takes in id of customer in api path and a body json with string field for addressStreetName and
    //string field for addressStreetNameNumber. Example:
    //      {
    //          "addressStreetName": "name of street",
    //          "addressStreetNameNumber": "id/number on house in the street"
    //      }
    @PostMapping("/{id}/newaddress")
    public Customer  createNewAddressAndAddItToCustomer(@PathVariable Long id,  @RequestBody NewAddressDTO newAddressDTO) {
        try {
            Customer customer = customerService.getCustomerById(id);
            Address address = new Address(newAddressDTO.getAddressStreetName(), newAddressDTO.getAddressStreetNameNumber());
            customer.getAddresses().add(address);
            return customerService.addCustomer(customer);
        } catch (Exception e) {
            return null;
        }
    }
}
