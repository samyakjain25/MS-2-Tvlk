package com.traveloka.ecommerce.exception;

public class ProductNotfoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ProductNotfoundException(String id)
    {
        super(id);
    }
}