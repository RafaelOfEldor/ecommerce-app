package com.mock_ecommerce_app.controller;

import com.mock_ecommerce_app.model.Order;
import com.mock_ecommerce_app.service.ItemService;
import com.mock_ecommerce_app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {


    private OrderService orderService;
    private ItemService itemService;
    @Autowired
    public OrderController(OrderService orderService, ItemService itemService) {
        this.itemService = itemService;
        this.orderService = orderService;
    }



    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/page/{pageNumber}")
    public List<Order> getOrdersByPage(@PathVariable int pageNumber) {
        return orderService.getOrdersPageable(pageNumber);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
