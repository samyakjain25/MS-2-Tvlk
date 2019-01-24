package com.traveloka.ecommerce.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpdateCartItemQuantityRequest {
    @NotNull
    private String accountId;
    @NotNull
    private String productId;
    @Min(value = 0)
    private Integer quantity;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
