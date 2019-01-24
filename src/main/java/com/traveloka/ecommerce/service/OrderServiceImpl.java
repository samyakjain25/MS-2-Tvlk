package com.traveloka.ecommerce.service;

import com.traveloka.ecommerce.model.Order;
import com.traveloka.ecommerce.repository.OrderRepository;
import com.traveloka.ecommerce.request.OrderPlaceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    Integer orderSeq = 1;


    @Override
    public void placeOrder(OrderPlaceRequest orderPlaceRequest) {
        Order order = new Order();
        order.setCartItemList(orderPlaceRequest.getCartItemList());
        order.setDeliveryAddress(orderPlaceRequest.getDeliveryAddress());
        order.setPhoneNumber(orderPlaceRequest.getPhoneNumber());
        order.setTotalAmountPayable(orderPlaceRequest.getTotalAmountPayable());
        order.setUserName(orderPlaceRequest.getUserName());
        order.setOrderId(String.format("OD-%s", orderSeq++));
        orderRepository.save(order);
    }
}
