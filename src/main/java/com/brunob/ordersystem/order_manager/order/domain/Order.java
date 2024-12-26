package com.brunob.ordersystem.order_manager.order.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderCode;
    private String description;
    private Double weight;
    private Double volume;
    private String status;
    private String recipientName;
    private String recipientPhone;

}
