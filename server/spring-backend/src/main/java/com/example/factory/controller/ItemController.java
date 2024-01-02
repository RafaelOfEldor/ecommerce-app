package com.example.factory.controller;

import com.example.factory.dtos.ExistingItemsDTO;
import com.example.factory.dtos.ExistingSubassembliesDTO;
import com.example.factory.dtos.NewItemDTO;
import com.example.factory.model.*;
import com.example.factory.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/machine")
public class ItemController {

    private final CustomerService customerService;
    private final ItemService itemService;
    private final AddressService addressService;
    private final OrderService orderService;
    @Autowired
    public ItemController(CustomerService customerService, AddressService addressService, OrderService orderService, ItemService itemService) {
        this.customerService = customerService;
        this.itemService = itemService;
        this.addressService = addressService;
        this.orderService = orderService;
    }


    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping("/page/{pageNumber}")
    public List<Item> getItemsByPage(@PathVariable int pageNumber) {
        try {
            return itemService.getItemsPageable(pageNumber);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/{id}")
    public Item getItemsById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public Item addItem(@RequestBody Item machine) {
        try {
            return itemService.addItem(machine);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Item updateItemById(@PathVariable Long id, @RequestBody Item machine) {
        try {
            return itemService.updateItem(id, machine);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    //Takes in id of order in parameter and a json with an array "machineId" of Long's corresponding to a machine's id.
    //Example:
    //      {
    //             "machineId": [
    //                           14, <-(the id of machine 14)
    //                           5, <-(the id of machine 5)
    //                           22 <-(the id of machine 22)
    //                           ]
    //      }
    @PostMapping("/order/{orderid}/addexistingmachines")
    public Order addExistingItemsToOrder(@PathVariable Long orderid,  @RequestBody ExistingItemsDTO existingItemDTO) {
        try {
            Order order = orderService.getOrderById(orderid);

            for (Long itemId : existingItemDTO.getItemId()) {
                Item item = itemService.getItemById(itemId);
                order.getItems().add(item);
            }

            return orderService.addOrder(order);
        } catch (Exception e) {
            return null;
        }
    }

}
