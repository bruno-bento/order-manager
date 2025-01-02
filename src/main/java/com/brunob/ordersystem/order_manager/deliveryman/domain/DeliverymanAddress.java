package com.brunob.ordersystem.order_manager.deliveryman.domain;

import com.brunob.ordersystem.order_manager.shared.domain.Address;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "deliveryman_address")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeliverymanAddress extends Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}