package com.brunob.ordersystem.order_manager.delivery.application;

import com.brunob.ordersystem.order_manager.delivery.domain.Delivery;
import com.brunob.ordersystem.order_manager.delivery.domain.DeliveryRepository;
import com.brunob.ordersystem.order_manager.delivery.infra.adapters.DeliverymanStatusChecker;
import com.brunob.ordersystem.order_manager.delivery.infra.adapters.OrderStatusChecker;
import com.brunob.ordersystem.order_manager.shared.application.exceptions.ResourceNotFoundException;
import com.brunob.ordersystem.order_manager.shared.enums.DeliveryStatus;
import com.brunob.ordersystem.order_manager.shared.enums.DeliverymanStatus;
import jakarta.persistence.EntityNotFoundException;
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

    @Autowired
    private OrderStatusChecker orderStatusChecker;

    public List<Delivery> getDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery createDelivery(CreateDeliveryDTO dto) {
        if(!deliverymanStatusChecker.isAvailable(dto.deliverymanId()))
            throw new IllegalArgumentException("O entregador não está disponível");

        if(!orderStatusChecker.isDeliverable(dto.orderId()))
            throw new IllegalArgumentException("A encomenda não está disponível");

        return deliveryRepository.save(deliveryMapper.fromDTO(dto));
    }

    public Delivery updateStatus(Long id, DeliveryStatusDTO dto) {
        try {
            Delivery delivery = deliveryRepository.getReferenceById(id);
            DeliveryStatus newStatus = DeliveryStatus.valueOf(dto.status().toUpperCase());
            delivery.setStatus(newStatus);
            delivery.updateDateTime();
            return deliveryRepository.save(delivery);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Status inválido: " + dto.status());
        }
    }
}
