package com.brunob.ordersystem.order_manager.shared.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
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

    public static List<String> getAllStatus() {
        return Arrays.stream(values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
