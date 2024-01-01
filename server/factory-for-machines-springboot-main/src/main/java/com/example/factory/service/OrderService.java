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
    private final MachineService machineService;
    @Autowired
    public OrderService(OrderRepository orderRepository, MachineService machineService) {
        this.orderRepository = orderRepository;
        this.machineService = machineService;
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
        Item machine = machineService.getMachineById(machineId);

        if (machine == null) {
            System.out.println("Machine not found!");
            return null;
        }

        System.out.println("Machine ID: " + machine.getMachineId());
        System.out.println("Machine Name: " + machine.getMachineName());

        Order order = new Order(orderName);
        order.getMachines().add(machine);
        order.setCustomer(customer);
        customer.getOrders().add(order);
        return orderRepository.save(order);

    }

    public Order createOrder(String orderName, Long machineId) {
        Order order = new Order(orderName);

        Item machine = machineService.getMachineById(machineId);

        if (machine == null) {
            System.out.println("Machine not found!");
        }

        order.getMachines().add(machine);

        return orderRepository.save(order);
    }

}
