package com.aiyanyorrosemary.shopEase.services;

import com.aiyanyorrosemary.shopEase.entities.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(Long id, List<Long> productIds);
    List<Order> getAllOrders(Long customerId);
    void cancelOrder(Long orderId);
}
