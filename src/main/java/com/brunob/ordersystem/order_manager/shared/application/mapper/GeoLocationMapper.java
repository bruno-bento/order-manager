package com.brunob.ordersystem.order_manager.shared.application.mapper;

import com.brunob.ordersystem.order_manager.deliveryman.domain.Deliveryman;
import com.brunob.ordersystem.order_manager.deliveryman.domain.DeliverymanAddress;
import com.brunob.ordersystem.order_manager.shared.application.dto.GeoLocationDTO;
import com.brunob.ordersystem.order_manager.shared.domain.GeoLocation;
import com.brunob.ordersystem.order_manager.shared.enums.DeliverymanStatus;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class GeoLocationMapper {

    public GeoLocation fromDTO(GeoLocationDTO dto) {
        return GeoLocation.builder()
                .latitude(dto.latitude())
                .longitude(dto.longitude())
                .build();
    }
}
