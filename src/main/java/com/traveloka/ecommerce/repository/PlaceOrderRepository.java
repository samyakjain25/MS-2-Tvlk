package com.traveloka.ecommerce.repository;

import com.traveloka.ecommerce.model.PlaceOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceOrderRepository extends MongoRepository<PlaceOrder,String> {
}
