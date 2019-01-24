package com.traveloka.ecommerce.repository;

import com.traveloka.ecommerce.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {

}
