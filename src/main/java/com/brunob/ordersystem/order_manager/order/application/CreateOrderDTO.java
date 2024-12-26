package com.brunob.ordersystem.order_manager.order.application;

public record CreateOrderDTO(
    String orderCode,
    String description,
    Double weight,
    Double volume,
    String status,
    String recipientName,
    String recipientPhone
) {
}