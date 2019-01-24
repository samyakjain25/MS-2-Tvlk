package com.traveloka.ecommerce.model;

import com.google.common.collect.Lists;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Cart {
    @Id
    String id;
    List<CartItem> cartItemList = Lists.newArrayList();
    String accountId;
    Double amountPayable = new Double(0);
    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }


}
