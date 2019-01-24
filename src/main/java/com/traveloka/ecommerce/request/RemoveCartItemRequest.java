package com.traveloka.ecommerce.request;

import javax.validation.constraints.NotNull;

public class RemoveCartItemRequest {
    @NotNull
    private String accountId;

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

    @NotNull
    private String productId;

}
