package com.brunob.ordersystem.order_manager.order.application;

public record CreateDeliveryAddressDTO(
        String zipCode,
        String address,
        String complement,
        String number,
        String district,
        String city,
        String state,
        String latitude,
        String longitude
){
}
