package com.traveloka.ecommerce.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.traveloka.ecommerce.model.Cart;
import com.traveloka.ecommerce.model.CartItem;
import com.traveloka.ecommerce.model.CustomResponse;
import com.traveloka.ecommerce.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/placeOrder")
public class PlaceOrderController {

    @Autowired
    PlaceOrderService placeOrderService;

    // before placing order, we validate the price of the product with the product catalogue
    // and check the quantity the user wants to buy with the inventory
    @RequestMapping(value="",method = RequestMethod.POST)
    public ResponseEntity<CustomResponse> validation(@RequestBody @Valid Cart cart) throws Exception
    {
        List<CartItem> list = new ArrayList<>();
        list = cart.getCartItemList();
        System.out.println(list);
        for (CartItem c:list) {
            System.out.println("Name = "+ c.getItem().getProductName() + " Quantity = "+ c.getItem().getQuantity());
        }
        return placeOrderService.validatePriceQuantity(cart);

    }
}
