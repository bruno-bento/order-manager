package com.brunob.ordersystem.order_manager.delivery.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByDeliverymanId(Long deliverymanId);
    List<Delivery> findByOrderId(Long orderId);
}
