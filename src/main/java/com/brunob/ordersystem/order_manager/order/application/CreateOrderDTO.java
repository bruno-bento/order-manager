package com.brunob.ordersystem.order_manager.order.application;

import com.brunob.ordersystem.order_manager.shared.enums.OrderStatus;

public record CreateOrderDTO(
    String orderCode,
    String description,
    Double weight,
    Double volume,
    OrderStatus status,
    String recipientName,
    String recipientPhone
) {
}