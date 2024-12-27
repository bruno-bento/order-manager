package com.brunob.ordersystem.order_manager.delivery.application;

public record CreateDeliveryDTO(
        Long deliverymanId,
        Long orderId
) {
}
