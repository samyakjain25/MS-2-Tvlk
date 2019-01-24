package com.traveloka.ecommerce.request;

import com.traveloka.ecommerce.model.CartItem;

import java.util.List;

public class CheckoutInitRequest {
    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    List<CartItem> cartItemList;
}
