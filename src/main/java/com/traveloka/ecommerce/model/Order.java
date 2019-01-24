package com.traveloka.ecommerce.model;
import java.util.List;

public class Order {
    private String orderId;
    private List<CartItem> cartItemList;
    private String userName;
    private String deliveryAddress;
    private String phoneNumber;
    private Double totalAmountPayable;
    private String paymentMode ="POSTPAID"; // would be updated once callback from payment system is received for successful payment


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Double getTotalAmountPayable() {
        return totalAmountPayable;
    }

    public void setTotalAmountPayable(Double totalAmountPayable) {
        this.totalAmountPayable = totalAmountPayable;
    }
}
