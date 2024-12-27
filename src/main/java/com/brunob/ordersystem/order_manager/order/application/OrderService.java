package com.brunob.ordersystem.order_manager.order.application;

import com.brunob.ordersystem.order_manager.order.domain.Order;
import com.brunob.ordersystem.order_manager.order.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(CreateOrderDTO createOrderDTO) {
        return orderRepository.save(orderMapper.fromDTO(createOrderDTO));
    }

    public boolean checkDeliveryStatus(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order.map(Order::isDeliverable).orElse(false);
    }
}
