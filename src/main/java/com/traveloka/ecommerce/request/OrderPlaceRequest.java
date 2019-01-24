package com.traveloka.ecommerce.request;

import com.traveloka.ecommerce.model.CartItem;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderPlaceRequest {

    List<CartItem> cartItemList;
    @NotNull(message = "delivery address should not be Null")
    String deliveryAddress;
    @NotNull
    String phoneNumber;
    @Email(message = "Email should be valid")
    String emailAddress;
    Double totalAmountPayable;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    String userName;

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Double getTotalAmountPayable() {
        return totalAmountPayable;
    }

    public void setTotalAmountPayable(Double totalAmountPayable) {
        this.totalAmountPayable = totalAmountPayable;
    }

    public Double getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    Double deliveryCharge;
}
