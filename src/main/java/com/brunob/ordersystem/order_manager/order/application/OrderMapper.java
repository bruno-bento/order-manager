package com.brunob.ordersystem.order_manager.order.application;

import com.brunob.ordersystem.order_manager.order.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    Order fromDTO(CreateOrderDTO order);
}
