package com.brunob.ordersystem.order_manager.deliveryman.domain;

import com.brunob.ordersystem.order_manager.shared.enums.DeliverymanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliverymanRepository extends JpaRepository<Deliveryman, Long> {
    List<Deliveryman> findByStatus(DeliverymanStatus status);
}