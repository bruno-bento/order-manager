package com.brunob.ordersystem.order_manager.shared.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    PENDING("PENDING"),
    IN_TRANSIT("IN TRANSIT"),
    DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED"),
    RETURNED("RETURNED");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

}
