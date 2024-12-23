package com.brunob.ordersystem.order_manager.order.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping("/test")
    public String testEndpoint() {
        String teste = "teste";

        return teste;
    }
}
