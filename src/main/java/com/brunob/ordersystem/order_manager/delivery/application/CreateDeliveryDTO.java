package com.brunob.ordersystem.order_manager.delivery.application;

import java.time.LocalDateTime;

public record CreateDeliveryDTO(
        Long deliverymanId,
        Long orderId
) {
}
