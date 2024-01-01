package com.example.factory.order;

import com.example.factory.model.Order;
import com.example.factory.service.OrderService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceIntegrationTest {

    @Autowired
    OrderService orderService;

    @Test
    @Transactional
    void canFetchOrders(){

        var orders = orderService.getOrders();

        assert orders.size() == 50;
    }

    @Test
    @Transactional
    void canFetchPageOfTenOrders(){

        var orders = orderService.getOrdersPageable(1);

        assert orders.size() == 10;
    }


    @Test
    @Transactional
    void canAddOrder(){
        assert orderService.getOrders().size() == 50;

        Order order = new Order("Order for xyz");
        orderService.addOrder(order);

        assert orderService.getOrders().size() == 51;

    }


    @Test
    @Transactional
    void canFetchOrderById(){
        Order order = new Order("Order for yzx");
        orderService.addOrder(order);

        assert orderService.getOrderById(order.getOrderId()) != null;
        assert orderService.getOrderById(order.getOrderId()).getOrderName().equals("Order for yzx");
    }

    @Test
    @Transactional
    void canDeleteOrder(){
        Order order = new Order("Order for zxy");
        orderService.addOrder(order);

        assert orderService.getOrderById(order.getOrderId()) != null;
        assert orderService.getOrders().size() == 51;

        orderService.deleteOrder(order.getOrderId());

        assert orderService.getOrderById(order.getOrderId()) == null;
        assert orderService.getOrders().size() == 50;
    }

    @Test
    @Transactional
    void canUpdateOrder(){
        Order order = new Order("Nintendo Switch for Jason Derulo");
        orderService.addOrder(order);

        assert orderService.getOrderById(order.getOrderId()) != null;
        assert orderService.getOrderById(order.getOrderId()).getOrderName() == "Nintendo Switch for Jason Derulo";

        Order updatedOrder = new Order("Nintendo Switch pro for Jason Derulo");
        orderService.updateOrder(order.getOrderId(), updatedOrder);

        assert orderService.getOrderById(order.getOrderId()).getOrderName() == "Nintendo Switch pro for Jason Derulo";
    }
}
