package com.brunob.ordersystem.order_manager.deliveryman.application;

import com.brunob.ordersystem.order_manager.deliveryman.domain.Deliveryman;
import com.brunob.ordersystem.order_manager.deliveryman.domain.DeliverymanRepository;
import com.brunob.ordersystem.order_manager.shared.enums.DeliverymanStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliverymanService {
    @Autowired
    private DeliverymanRepository deliverymanRepository;

    @Autowired
    private DeliverymanMapper deliverymanMapper;

    public List<Deliveryman> getDeliverymans() {
        return deliverymanRepository.findAll();
    }

    public Deliveryman createDeliveryman(CreateDeliverymanDTO dto) {
        return deliverymanRepository.save(deliverymanMapper.fromDTO(dto));
    }

    public boolean checkStatus(Long deliverymanId){
        Optional<Deliveryman> deliveryman = deliverymanRepository.findById(deliverymanId);
        return deliveryman.map(Deliveryman::isAvailable).orElse(false);
    }

    public List<Deliveryman> getDeliverymansByStatusOrReturnStatuses(String status) {
        String statusMessage = ". Possíveis status: " + String.join(", ", DeliverymanStatus.getAllStatus());

        DeliverymanStatus deliverymanStatus;
        try {
            deliverymanStatus = DeliverymanStatus.valueOf(status);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Status inválido: '" + status + "'" + statusMessage);
        }

        List<Deliveryman> deliverymen = deliverymanRepository.findByStatus(deliverymanStatus);

        if (deliverymen.isEmpty()) throw new IllegalArgumentException("Sem entregadores com esse status: '" + status + "'" + statusMessage);

        return deliverymen;
    }
}
