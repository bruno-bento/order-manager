package com.brunob.ordersystem.order_manager.order.application;

import com.brunob.ordersystem.order_manager.order.domain.OrderAddress;
import com.brunob.ordersystem.order_manager.order.domain.Order;
import com.brunob.ordersystem.order_manager.shared.domain.GeoLocation;
import com.brunob.ordersystem.order_manager.shared.enums.OrderStatus;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class OrderMapper {

    public Order fromDTO(CreateOrderDTO dto) {
        return Order.builder()
                .orderCode(dto.orderCode())
                .description(dto.description())
                .weight(dto.weight())
                .volume(dto.volume())
                .status(dto.status() != null ? dto.status() : OrderStatus.PENDING)
                .recipientName(dto.recipientName())
                .recipientPhone(dto.recipientPhone())
                .address(OrderAddress.builder()
                        .zipCode(dto.address().zipCode())
                        .address(dto.address().address())
                        .number(dto.address().number())
                        .complement(dto.address().complement())
                        .district(dto.address().district())
                        .city(dto.address().city())
                        .state(dto.address().state())
                        .geoLocation(GeoLocation.builder()
                                .longitude(dto.address().geoLocation().longitude())
                                .latitude(dto.address().geoLocation().latitude())
                                .build())
                        .build())
                .build();
    }
}
