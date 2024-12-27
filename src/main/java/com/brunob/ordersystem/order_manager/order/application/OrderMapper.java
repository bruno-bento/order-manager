package com.brunob.ordersystem.order_manager.order.application;

import com.brunob.ordersystem.order_manager.order.domain.DeliveryAddress;
import com.brunob.ordersystem.order_manager.order.domain.Order;
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
                .deliveryAddress(DeliveryAddress.builder()
                        .zipCode(dto.deliveryAddress().zipCode())
                        .address(dto.deliveryAddress().address())
                        .number(dto.deliveryAddress().number())
                        .complement(dto.deliveryAddress().complement())
                        .district(dto.deliveryAddress().district())
                        .city(dto.deliveryAddress().city())
                        .state(dto.deliveryAddress().state())
                        .latitude(dto.deliveryAddress().latitude())
                        .longitude(dto.deliveryAddress().longitude())
                        .build())
                .build();
    }
}
