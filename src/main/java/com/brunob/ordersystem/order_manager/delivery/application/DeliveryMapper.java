package com.brunob.ordersystem.order_manager.delivery.application;

import com.brunob.ordersystem.order_manager.delivery.domain.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class DeliveryMapper {

    public Delivery fromDTO(CreateDeliveryDTO dto) {
        return Delivery.builder()
                .deliverymanId(dto.deliverymanId())
                .orderId(dto.orderId())
                .build();
    }
}
