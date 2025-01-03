package com.brunob.ordersystem.order_manager.delivery.infra;

import com.brunob.ordersystem.order_manager.delivery.infra.adapters.DeliverymanStatusChecker;
import com.brunob.ordersystem.order_manager.deliveryman.application.DeliverymanService;
import org.springframework.stereotype.Component;

@Component
public class DeliverymanStatusAdapter implements DeliverymanStatusChecker {
    private final DeliverymanService deliverymanService;

    public DeliverymanStatusAdapter(DeliverymanService deliverymanService) {
        this.deliverymanService = deliverymanService;
    }
    @Override
    public boolean isAvailable(Long deliverymanId){
        return deliverymanService.checkStatus(deliverymanId);
    }
}