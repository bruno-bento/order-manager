package com.brunob.ordersystem.order_manager.order.application;

import com.brunob.ordersystem.order_manager.order.domain.Order;
import com.brunob.ordersystem.order_manager.order.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public Order createOrder(CreateOrderDTO createOrderDTO){
        return orderRepository.save(orderMapper.fromDTO(createOrderDTO));
    }
}
