package com.traveloka.ecommerce.controller;

public class ProductNotfoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ProductNotfoundException(String id)
    {
        super(id);
    }
}