package com.traveloka.ecommerce.repository;

//package com.example.repository;

import com.traveloka.ecommerce.model.Product;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}

