package com.brunob.ordersystem.order_manager.delivery.infra.adapters;

public interface DeliverymanStatusChecker {
    boolean isAvailable(Long deliverymanId);
}
