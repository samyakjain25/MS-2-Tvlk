package com.traveloka.ecommerce.repository;

import com.traveloka.ecommerce.model.Cart;

public interface CartRepositoryCustom {
    public Cart fetchCartByAccountId(String accountId);
}
