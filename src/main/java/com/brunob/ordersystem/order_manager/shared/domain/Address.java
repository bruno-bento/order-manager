package com.brunob.ordersystem.order_manager.shared.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Address {
    private String zipCode;
    private String address;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private GeoLocation geoLocation;
}