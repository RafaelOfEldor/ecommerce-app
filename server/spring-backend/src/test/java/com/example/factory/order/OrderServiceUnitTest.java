package com.example.factory.order;

import com.example.factory.model.Order;
import com.example.factory.repository.OrderRepository;
import com.example.factory.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceUnitTest {

    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;


    @Test
    void shouldFetchAllOrders(){

        List<Order> orderList = List.of(new Order(), new Order());

        when(orderRepository.findAll()).thenReturn(orderList);

        assert orderService.getOrders().size() == 2;
    }

    @Test
    void shouldAddAOrder(){
        Order order = new Order("order for xyz");

        when(orderRepository.save(order)).thenReturn(order);

        assert orderService.addOrder(order).getOrderName().equals("order for xyz");
    }

    @Test
    void shouldFetchOrderById(){
        Optional<Order> order = Optional.of(new Order("order for yzx"));

        Mockito.<Optional<Order>>when(orderRepository.findById(order.get().getOrderId())).thenReturn(order);

        assert orderService.getOrderById(order.get().getOrderId()).getOrderName().equals("order for yzx");
    }

    @Test
    void shouldUpdateOrder() {
        Order existingOrder = new Order("Order for Jason Derulo");
        when(orderRepository.save(existingOrder)).thenReturn(existingOrder);

        Order updatedOrder = new Order("Order for Mac Miller");
        Optional<Order> optionalUpdatedOrder = Optional.of(updatedOrder);

        when(orderRepository.findById(5L)).thenReturn(optionalUpdatedOrder);
        when(orderRepository.save(updatedOrder)).thenReturn(updatedOrder);

        assert  orderService.updateOrder(5L, updatedOrder).getOrderName().equals("Order for Mac Miller");
    }

    @Test
    void shouldDeleteOrder() {

        long idOfOrderToDelete = 5L;

        when(orderRepository.existsById(idOfOrderToDelete)).thenReturn(true);

        orderService.deleteOrder(idOfOrderToDelete);

        verify(orderRepository).deleteById(idOfOrderToDelete);
    }
}
