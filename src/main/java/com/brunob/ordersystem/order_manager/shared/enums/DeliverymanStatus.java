package com.brunob.ordersystem.order_manager.shared.enums;

public enum DeliverymanStatus {
    AVAILABLE("AVAILABLE"),
    IN_TRANSIT("IN TRANSIT"),
    WAITING_FOR_LOADING("WAITING FOR LOADING"),
    LOADED("LOADED"),
    DELIVERING("DELIVERING"),
    COMPLETED("COMPLETED"),
    ON_BREAK("ON BREAK"),
    MAINTENANCE("MAINTENANCE"),
    UNAVAILABLE("UNAVAILABLE"),
    RETURNING_TO_BASE("RETURNING TO BASE");

    private final String description;

    DeliverymanStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
