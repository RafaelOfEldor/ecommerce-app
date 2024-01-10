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
@RequestMapping("/api/v1/products")
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

    @GetMapping("/apparel/page/{pageNumber}")
    public List<Item> getApparelByPage(@PathVariable int pageNumber) {
        try {
            return itemService.getApparelPageable(pageNumber);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/jewelry/page/{pageNumber}")
    public List<Item> getJewelryByPage(@PathVariable int pageNumber) {
        try {
            return itemService.getJewelryPageable(pageNumber);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/technology/page/{pageNumber}")
    public List<Item> getTechnologyItemsByPage(@PathVariable int pageNumber) {
        try {
            return itemService.getTechnologyPageable(pageNumber);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/gardening/page/{pageNumber}")
    public List<Item> getGardeningItemsByPage(@PathVariable int pageNumber) {
        try {
            return itemService.getGardeningPageable(pageNumber);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/consumables/page/{pageNumber}")
    public List<Item> getConsumablesItemsByPage(@PathVariable int pageNumber) {
        try {
            return itemService.getConsumablesPageable(pageNumber);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/furniture/page/{pageNumber}")
    public List<Item> getFurnitureItemsByPage(@PathVariable int pageNumber) {
        try {
            return itemService.getFurniturePageable(pageNumber);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/{id}")
    public Item getItemsById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }


}
