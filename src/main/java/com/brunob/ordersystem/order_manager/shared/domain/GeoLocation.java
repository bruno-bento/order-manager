package com.brunob.ordersystem.order_manager.shared.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class GeoLocation {
    private Double latitude;
    private Double longitude;
}
