package com.example.factory.controller;

import com.example.factory.dtos.ExistingItemsDTO;
import com.example.factory.model.Order;
import com.example.factory.service.ItemService;
import com.example.factory.service.OrderService;
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

//    @PostMapping
//    public Order addOrder(@RequestBody Order newOrder) {
//        try {
//            if (newOrder.getUser() != null) {
//                Customer customer = customerService.addCustomer(newOrder.getUser());
//            }
//            Order order = orderService.addOrder(newOrder);
//            order.setOrderName(newOrder.getOrderName());
//
//            return order;
//        } catch (Exception e) {
//            return null;
//        }
//    }

//    @PostMapping("/{id}/addexistingmachines")
//    public Order addItemsToOrder(@PathVariable Long id, @RequestBody ExistingItemsDTO machines) {
//        try {
//            Order order = orderService.getOrderById(id);
//            for (Long machineId : machines.getItemId()) {
//                order.getItems().add(itemService.getItemById(machineId));
//            }
//            return orderService.addOrder(order);
//        } catch (Exception e) {
//            return null;
//        }
//    }

    @PutMapping("/{id}")
    public Order updateOrderById(@PathVariable Long id, @RequestBody Order order) {
        try {
            return orderService.updateOrder(id, order);
        } catch (Exception e) {
            return null;
        }
    }

//    @DeleteMapping("/{id}")
//    public void deleteOrder(@PathVariable Long id) {
//        try {
//            Order order = orderService.getOrderById(id);
//            Customer customer = customerService.getCustomerById(order.getUser().getId());
//            order.setUser(null);
//            order.setItems(null);
//            customer.getOrders().remove(order);
//            customerService.addCustomer(customer);
//            orderService.deleteOrder(id);
//        } catch (Exception e) {
//
//        }
//    }

}
