package com.brunob.ordersystem.order_manager.deliveryman.application;

import com.brunob.ordersystem.order_manager.deliveryman.domain.Deliveryman;
import com.brunob.ordersystem.order_manager.shared.enums.DeliverymanStatus;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class DeliverymanMapper {

    public Deliveryman fromDTO(CreateDeliverymanDTO dto) {
        return Deliveryman.builder()
                .name(dto.name())
                .document(dto.document())
                .phone(dto.phone())
                .nationalDrivingLicense(dto.nationalDrivingLicense())
                .email(dto.email())
                .status(dto.status() != null ? dto.status() : DeliverymanStatus.AVAILABLE)
                .build();
    }
}
