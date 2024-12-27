package com.brunob.ordersystem.order_manager.delivery.infra;

import com.brunob.ordersystem.order_manager.delivery.infra.adapters.OrderStatusChecker;
import com.brunob.ordersystem.order_manager.order.application.OrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusAdapter implements OrderStatusChecker {
    private OrderService orderService;

    @Override
    public boolean isDeliverable(Long orderId) {
        return orderService.checkDeliveryStatus(orderId);
    }
}
