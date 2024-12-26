package com.brunob.ordersystem.order_manager.deliveryman.infrastructure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliveryman")
public class DeliverymanController {

    @GetMapping
    public String GetDeliveryman(){
        return "test deliveryman";
    }
}
