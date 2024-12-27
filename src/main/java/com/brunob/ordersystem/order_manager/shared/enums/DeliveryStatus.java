package com.brunob.ordersystem.order_manager.shared.enums;

public enum DeliveryStatus {
    PENDING("PENDING"),
    IN_PROGRESS("IN PROGRESS"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");

    private final String description;

    DeliveryStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}