package com.brunob.ordersystem.order_manager.deliveryman.infra;

import com.brunob.ordersystem.order_manager.deliveryman.application.CreateDeliverymanDTO;
import com.brunob.ordersystem.order_manager.deliveryman.application.DeliverymanService;
import com.brunob.ordersystem.order_manager.deliveryman.domain.Deliveryman;
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
