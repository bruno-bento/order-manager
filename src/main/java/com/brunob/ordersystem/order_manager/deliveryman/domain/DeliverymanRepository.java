package com.brunob.ordersystem.order_manager.deliveryman.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliverymanRepository extends JpaRepository<Deliveryman, Long> {
    Optional<Deliveryman> findById(String id);
}
