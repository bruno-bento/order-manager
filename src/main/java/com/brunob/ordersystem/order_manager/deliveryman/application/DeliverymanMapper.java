package com.brunob.ordersystem.order_manager.deliveryman.application;

import com.brunob.ordersystem.order_manager.deliveryman.domain.Deliveryman;
import com.brunob.ordersystem.order_manager.deliveryman.domain.DeliverymanAddress;
import com.brunob.ordersystem.order_manager.order.domain.OrderAddress;
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
                .address(DeliverymanAddress.builder()
                        .zipCode(dto.address().zipCode())
                        .address(dto.address().address())
                        .number(dto.address().number())
                        .complement(dto.address().complement())
                        .district(dto.address().district())
                        .city(dto.address().city())
                        .state(dto.address().state())
                        .latitude(dto.address().latitude())
                        .longitude(dto.address().longitude())
                        .build())
                .build();
    }
}
