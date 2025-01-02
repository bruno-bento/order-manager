package com.brunob.ordersystem.order_manager.delivery.domain;

import com.brunob.ordersystem.order_manager.shared.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Clock;
import java.time.Instant;
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
    private Instant expectedDate;
    private Instant startDate;
    private Instant endDate;
    private DeliveryStatus status;

    public void updateDateTime(){
        switch (this.status){
            case IN_PROGRESS:
                this.startDate = Instant.now();
                break;
            case COMPLETED:
                this.endDate = Instant.now();
                break;
        }
    }
}
