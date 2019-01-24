package com.traveloka.ecommerce.controller;


import com.traveloka.ecommerce.model.CartItem;
import com.traveloka.ecommerce.model.Order;
import com.traveloka.ecommerce.model.Product;
import com.traveloka.ecommerce.repository.OrderRepository;
import com.traveloka.ecommerce.repository.ProductRepository;
import com.traveloka.ecommerce.request.AddToCartRequest;
import com.traveloka.ecommerce.request.CheckoutInitRequest;
import com.traveloka.ecommerce.request.OrderPlaceRequest;
import com.traveloka.ecommerce.response.CheckoutInitResponse;
import com.traveloka.ecommerce.service.CartService;
import com.traveloka.ecommerce.service.OrderService;
import com.traveloka.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value="/init",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CheckoutInitResponse init(@RequestBody CheckoutInitRequest checkoutInitRequest) {
        Double DELIVERY_CHARGE = 40.00;
        Double totalPrice = 0.0;
        Double totalPayable = 0.0;
        for(CartItem cartItem : checkoutInitRequest.getCartItemList()){
            totalPrice = totalPrice + cartItem.getItem().getPrice()*cartItem.getQuantity();
        }
        if(totalPrice >= 500)
            DELIVERY_CHARGE = 0.0;
        totalPayable = totalPrice + DELIVERY_CHARGE;
        CheckoutInitResponse checkoutInitResponse = new CheckoutInitResponse();
        checkoutInitResponse.setAmountPayable(totalPayable);
        checkoutInitResponse.setCartItemList(checkoutInitRequest.getCartItemList());
        checkoutInitResponse.setDeliveryCharge(DELIVERY_CHARGE);
        checkoutInitResponse.setTotalPrice(totalPrice);
        return checkoutInitResponse;
    }

    @RequestMapping(value="/placeOrder",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void placeorder(@RequestBody @Valid OrderPlaceRequest orderPlaceRequest) {
        orderService.placeOrder(orderPlaceRequest);
    }
}
