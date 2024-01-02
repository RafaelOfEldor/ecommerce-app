package com.example.factory.controller;

import com.example.factory.dtos.*;
import com.example.factory.model.*;
import com.example.factory.service.AddressService;
import com.example.factory.service.CustomerService;
import com.example.factory.service.ItemService;
import com.example.factory.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final ItemService itemService;
    private final AddressService addressService;
    private final OrderService orderService;

    @Autowired
    public CustomerController(CustomerService customerService, AddressService addressService, OrderService orderService, ItemService itemService) {
        this.customerService = customerService;
        this.itemService = itemService;
        this.addressService = addressService;
        this.orderService = orderService;
    }


    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/page/{pageNumber}")
    public List<Customer> getCustomersByPage(@PathVariable int pageNumber) {
        return customerService.getCustomersPageable(pageNumber);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer newCustomer) {
        try {
        Customer customer = customerService.addCustomer(newCustomer);
        for (Order order : customer.getOrders()) {
            order.setCustomer(customer);
            orderService.addOrder(order);
        }
//        return customerService.addCustomer(newCustomer);
        return customer;
        } catch (Exception e) {
            return null;
        }
    }

    //Mainly set up to take in string fields for "customerName" or "customerEmail"
    @PutMapping("/{id}")
    public Customer updateCustomerById(@PathVariable Long id, @RequestBody Customer customer) {
        try {
            return customerService.updateCustomer(id, customer);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        try {
            Customer customer = customerService.getCustomerById(id);
            for (Address address : customer.getAddresses()) {
                customer.setAddresses(null);
                address.getCustomers().remove(customer);
            }
            for (Order order : customer.getOrders()) {
                order.setCustomer(null);
                customer.setOrders(null);
            }
        customerService.deleteCustomer(id);
        } catch (Exception e) {

        }
    }

    //Takes in id of customer in parameter and a json with string field for orderName and
    //an array "machineId" of Long's corresponding to a machine's id. Example:
    //    {
    //        "orderName": "order for (name here) ", <-(just a name or description of the order.)
    //        "machineId": [
    //                          14, <-(the id of machine 14)
    //                          5, <-(the id of machine 5)
    //                          22 <-(the id of machine 22)
    //                     ]
    //    }
    @PostMapping("/{id}/order")
    public Customer createNewOrderAndAddItToCustomer(@PathVariable Long id, @RequestBody NewOrderDTO newOrderDTO) {
        try {
            Customer customer = customerService.getCustomerById(id);
            Order order = new Order(newOrderDTO.getOrderName());

            for (Long machineId : newOrderDTO.getItemId()) {
                Item machine = itemService.getItemById(machineId);
                order.getItems().add(machine);
            }

            customer.getOrders().add(order);
            order.setCustomer(customer);
            return customerService.addCustomer(customer);
        } catch (Exception e) {
            return null;
        }
    }
    //Takes in id of customer in parameter and a json with Long field "addressId"
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

    //Takes in id of customer in parameter and a json with string field for addressStreetName and
    //string field for addressStreetNameNumber. Example:
    //      {
    //          "addressStreetName": "street name",
    //          "addressStreetNameNumber": "number on house"
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

    //Takes in id of customer in parameter and a json with string field for "customerName",
    //string field for "customerEmail" and Long field for "addressId". Example:
    //      {
    //          "customerName": "name of customer",
    //          "customerEmail": "email of customer"
    //          "addressId": 5 <- (id of existing address)
    //      }
    @PostMapping("/newcustomer/existingaddress")
    public Customer  createNewCustomerAndAddToExistingAddress(@RequestBody NewCustomerWithExistingAddressDTO newCustomer) {
        try {
            Customer customer = customerService.addCustomer(new Customer(newCustomer.getCustomerName(), newCustomer.getCustomerEmail()));
            customer.getAddresses().add(addressService.getAddressById(newCustomer.getAddressId()));
            return customerService.addCustomer(customer);
        } catch (Exception e) {
            return null;
        }
    }

    //Takes in id of customer in parameter and a json with string field for "customerName",
    //string field for "customerEmail", String field for "addressStreetName"
    //String field for "addressStreetNameNumber" "addressId". Example:
    //      {
    //          "customerName": "name of customer",
    //          "customerEmail": "email of customer"
    //          "addressStreetName": "name of street"
    //          "addressStreetNameNumber": "number on house"
    //      }
    @PostMapping("/newcustomer/newaddress")
    public Customer  createNewCustomerAndAddToNewAddress(@RequestBody NewCustomerWithNewAddressDTO newCustomer) {
        try {
            Customer customer = customerService.addCustomer(new Customer(newCustomer.getCustomerName(), newCustomer.getCustomerEmail()));
            Address address = addressService.addAddress(new Address(newCustomer.getAddressStreetName(), newCustomer.getAddressStreetNameNumber()));
            customer.getAddresses().add(address);
            return customerService.addCustomer(customer);
        } catch (Exception e) {
            return null;
        }
    }

}
