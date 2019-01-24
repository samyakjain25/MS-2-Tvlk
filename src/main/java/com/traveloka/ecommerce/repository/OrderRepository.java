package com.traveloka.ecommerce.repository;

//package com.example.repository;

import com.traveloka.ecommerce.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

}

