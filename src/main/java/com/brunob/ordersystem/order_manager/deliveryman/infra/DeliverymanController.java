package com.brunob.ordersystem.order_manager.deliveryman.infra;

import com.brunob.ordersystem.order_manager.deliveryman.application.CreateDeliverymanDTO;
import com.brunob.ordersystem.order_manager.deliveryman.application.DeliverymanService;
import com.brunob.ordersystem.order_manager.deliveryman.application.UpdateAvailabilityDTO;
import com.brunob.ordersystem.order_manager.deliveryman.domain.Deliveryman;
import com.brunob.ordersystem.order_manager.shared.application.dto.GeoLocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveryman")
public class DeliverymanController {

    @Autowired
    private DeliverymanService deliverymanService;

    // Get all deliverymans
    @GetMapping
    public ResponseEntity<List<Deliveryman>> getDeliverymans(){
        List<Deliveryman> deliverymans = deliverymanService.getDeliverymans();
        return new ResponseEntity<>(deliverymans, HttpStatus.OK);
    }

    // Create new deliveryman
    @PostMapping
    public ResponseEntity<Deliveryman> create(@RequestBody CreateDeliverymanDTO deliverymanDTO){
        Deliveryman deliveryman = deliverymanService.createDeliveryman(deliverymanDTO);
        return new ResponseEntity<>(deliveryman, HttpStatus.CREATED);
    }

    // Atualiza localização atual do entregador
    @PutMapping("/{id}/location")
    public ResponseEntity<Void> updateLocation(@PathVariable Long id, @RequestBody GeoLocationDTO dto) {
        deliverymanService.updateCurrentLocation(id, dto);
        return ResponseEntity.ok().build();
    }

    // Atualiza a disponibilidade atual do entregador
    @PutMapping("/{id}/availability")
    public ResponseEntity<Deliveryman> updateAvailability(@PathVariable Long id, @RequestBody UpdateAvailabilityDTO dto) {
        Deliveryman deliveryman = deliverymanService.updateAvailability(id, dto);
        return new ResponseEntity<>(deliveryman, HttpStatus.OK);
    }

    // Get Deliveryman by status
    @GetMapping("/status/{status}")
    public ResponseEntity<?> getDeliverymansByStatus(@PathVariable String status) {
        try {
            List<Deliveryman> deliverymen = deliverymanService.getDeliverymansByStatusOrReturnStatuses(status);
            return ResponseEntity.ok(deliverymen);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
