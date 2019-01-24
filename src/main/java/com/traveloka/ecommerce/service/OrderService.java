package com.traveloka.ecommerce.service;

import com.traveloka.ecommerce.request.OrderPlaceRequest;

public interface OrderService {
    public void placeOrder(OrderPlaceRequest orderPlaceRequest);
}