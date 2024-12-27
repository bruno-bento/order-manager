package com.brunob.ordersystem.order_manager.delivery.application;

import com.brunob.ordersystem.order_manager.delivery.domain.Delivery;
import com.brunob.ordersystem.order_manager.delivery.domain.DeliveryRepository;
import com.brunob.ordersystem.order_manager.delivery.infra.adapters.DeliverymanStatusChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DeliveryMapper deliveryMapper;

    @Autowired
    private DeliverymanStatusChecker deliverymanStatusChecker;

    public List<Delivery> getDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery createDelivery(CreateDeliveryDTO dto) {
        if(!deliverymanStatusChecker.isAvailable(dto.deliverymanId()))
            throw new IllegalArgumentException("O entregador não está disponível");

        return deliveryRepository.save(deliveryMapper.fromDTO(dto));
    }}