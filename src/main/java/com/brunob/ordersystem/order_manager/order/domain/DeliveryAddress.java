package com.brunob.ordersystem.order_manager.order.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "delivery_address")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeliveryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zipCode;
    private String address;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String latitude;
    private String longitude;

}
