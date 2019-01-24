package com.traveloka.ecommerce.controller;

import com.traveloka.ecommerce.model.PlaceOrder;
import com.traveloka.ecommerce.repository.PlaceOrderRepository;
import com.traveloka.ecommerce.request.AddToCartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ship")
public class PlaceOrderController {

    @Autowired
    PlaceOrderRepository placeOrderRepository;

    @PostMapping
    public void addShip(@RequestBody @Valid PlaceOrder order)
    {
        placeOrderRepository.save(order);
    }
}
