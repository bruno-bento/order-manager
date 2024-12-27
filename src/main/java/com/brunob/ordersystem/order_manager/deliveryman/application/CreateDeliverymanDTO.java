package com.brunob.ordersystem.order_manager.deliveryman.application;

import com.brunob.ordersystem.order_manager.shared.enums.DeliverymanStatus;

public record CreateDeliverymanDTO(
        String name,
        String document,
        String phone,
        String nationalDrivingLicense,
        String email,
        DeliverymanStatus status
) {
}
