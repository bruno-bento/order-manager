package com.brunob.ordersystem.order_manager.delivery.infra.adapters;

public interface OrderStatusChecker {
    boolean isDeliverable(Long orderId);
}
