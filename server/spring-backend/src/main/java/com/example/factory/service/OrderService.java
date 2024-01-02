package com.example.factory.service;

import com.example.factory.model.Customer;
import com.example.factory.model.Item;
import com.example.factory.model.Order;
import com.example.factory.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemService itemService;
    @Autowired
    public OrderService(OrderRepository orderRepository, ItemService itemService) {
        this.orderRepository = orderRepository;
        this.itemService = itemService;
    }

    public Order addOrder(Order Order) {
        return orderRepository.save(Order);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersPageable(int pageNumber) {
        return orderRepository.findAll(PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrder(Long id) { orderRepository.deleteById(id);}

    public Order updateOrder(Long id, Order newOrder) {

        return orderRepository.findById(id)
                .map(order -> {
                    if (newOrder.getOrderName() != null) {
                        order.setOrderName(newOrder.getOrderName());
                    }
                    return orderRepository.save(order);
                })
                .orElseGet(() -> {
                    return orderRepository.save(newOrder);
                });
    }

    public Order addOrderToCustomer(Customer customer, String orderName, Long machineId) {
        Item machine = itemService.getItemById(machineId);

        if (machine == null) {
            System.out.println("Item not found!");
            return null;
        }

        System.out.println("Item ID: " + machine.getItemId());
        System.out.println("Item Name: " + machine.getItemName());

        Order order = new Order(orderName);
        order.getItems().add(machine);
        order.setCustomer(customer);
        customer.getOrders().add(order);
        return orderRepository.save(order);

    }

    public Order createOrder(String orderName, Long machineId) {
        Order order = new Order(orderName);

        Item machine = itemService.getItemById(machineId);

        if (machine == null) {
            System.out.println("Item not found!");
        }

        order.getItems().add(machine);

        return orderRepository.save(order);
    }

}
