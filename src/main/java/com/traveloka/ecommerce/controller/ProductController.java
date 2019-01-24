package com.traveloka.ecommerce.controller;


import com.traveloka.ecommerce.model.Product;
import com.traveloka.ecommerce.repository.ProductRepository;
import com.traveloka.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Product product) {
        productRepository.save(product);
    }

    @RequestMapping(value = "/{id}")
    public Product fetchProductById(@PathVariable String id) {
        return productRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        productRepository.delete(id);
    }


    @RequestMapping (value ="")
    public  Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
