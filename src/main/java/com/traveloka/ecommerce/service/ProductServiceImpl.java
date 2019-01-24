package com.traveloka.ecommerce.service;

import com.traveloka.ecommerce.model.Product;
import com.traveloka.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    @Override
    public Product getProduct(String id) {
        return productRepository.findOne(id);
    }
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public  void delete(String id)
    {
        productRepository.delete(id);
    }


}

