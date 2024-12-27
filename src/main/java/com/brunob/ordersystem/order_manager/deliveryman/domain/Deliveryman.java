package com.brunob.ordersystem.order_manager.deliveryman.domain;

import com.brunob.ordersystem.order_manager.shared.enums.DeliverymanStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "deliveryman")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Deliveryman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String document;
    private String phone;
    private String nationalDrivingLicense;
    private String email;

    @Enumerated(EnumType.STRING)
    private DeliverymanStatus status;

    public boolean isAvailable(){
        return this.status == DeliverymanStatus.AVAILABLE;
    }
}
