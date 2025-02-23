package com.aiyanyorrosemary.shopEase.services.Implementation;

import com.aiyanyorrosemary.shopEase.entities.Order;
import com.aiyanyorrosemary.shopEase.entities.Product;
import com.aiyanyorrosemary.shopEase.exception.ResourceNotFoundException;
import com.aiyanyorrosemary.shopEase.repository.OrderRepository;
import com.aiyanyorrosemary.shopEase.repository.ProductRepository;
import com.aiyanyorrosemary.shopEase.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
@Service
public class OrderServiceImplementation implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Order placeOrder(Long id, List<Long> productIds) {
        List<Product> products = productRepository.findAllById(productIds);
        Order order = new Order();
        order.setId(id);
        order.setProducts(products);
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }
    @Override
    public List<Order> getAllOrders(Long customerId) {
        return orderRepository.findAllById(Collections.singleton(customerId));
    }
    @Override
    public void cancelOrder(Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        } else {
        throw new ResourceNotFoundException("Order Not Found");
    }
    }
}
