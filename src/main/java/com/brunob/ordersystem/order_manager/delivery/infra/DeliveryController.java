package com.brunob.ordersystem.order_manager.delivery.infra;

import com.brunob.ordersystem.order_manager.delivery.application.CreateDeliveryDTO;
import com.brunob.ordersystem.order_manager.delivery.application.DeliveryService;
import com.brunob.ordersystem.order_manager.delivery.application.DeliveryStatusDTO;
import com.brunob.ordersystem.order_manager.delivery.domain.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<List<Delivery>> getDeliveries() {
        List<Delivery> deliveries = deliveryService.getDeliveries();
        return new ResponseEntity<>(deliveries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Delivery> create(@RequestBody CreateDeliveryDTO dto) {
        Delivery delivery = deliveryService.createDelivery(dto);
        return new ResponseEntity<>(delivery, HttpStatus.CREATED);
    }

    // Atualiza status e datas (início/conclusão) da entrega
    @PutMapping("/{id}/status")
    public ResponseEntity<Delivery> updateStatus(@PathVariable Long id, @RequestBody DeliveryStatusDTO dto) {
        Delivery delivery = deliveryService.updateStatus(id, dto);
        return new ResponseEntity<>(delivery, HttpStatus.OK);
    }
}
