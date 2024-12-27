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

    @GetMapping
    public ResponseEntity<List<Deliveryman>> getDeliverymans(){
        List<Deliveryman> deliverymans = deliverymanService.getDeliverymans();
        return new ResponseEntity<>(deliverymans, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Deliveryman> create(@RequestBody CreateDeliverymanDTO deliverymanDTO){
        Deliveryman deliveryman = deliverymanService.createDeliveryman(deliverymanDTO);
        return new ResponseEntity<>(deliveryman, HttpStatus.CREATED);
    }
}
