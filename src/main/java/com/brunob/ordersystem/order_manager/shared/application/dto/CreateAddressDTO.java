package com.brunob.ordersystem.order_manager.shared.application.dto;

public record CreateAddressDTO (
        String zipCode,
        String address,
        String complement,
        String number,
        String district,
        String city,
        String state,
        GeoLocationDTO geoLocation
) {
}
