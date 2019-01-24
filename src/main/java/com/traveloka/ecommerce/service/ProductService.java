package com.traveloka.ecommerce.service;

import com.traveloka.ecommerce.model.Product;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ProductService {

    List<Product> getAllProducts();

    Product getProduct( String id);

    Product save(Product product);

     void delete(String id);
}
