package com.brunob.ordersystem.order_manager.order.infrastructure;

import com.brunob.ordersystem.order_manager.order.application.CreateOrderDTO;
import com.brunob.ordersystem.order_manager.order.application.OrderService;
import com.brunob.ordersystem.order_manager.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){
        List<Order> orders = orderService.getOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody CreateOrderDTO orderDTO){
        Order order = orderService.createOrder(orderDTO);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
