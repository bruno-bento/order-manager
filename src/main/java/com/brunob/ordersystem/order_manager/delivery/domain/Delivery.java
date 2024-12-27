package com.brunob.ordersystem.order_manager.delivery.domain;

import com.brunob.ordersystem.order_manager.shared.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "delivery")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deliverymanId;
    private Long orderId;
    private LocalDateTime expectedDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private DeliveryStatus status;
}
