package com.aiyanyorrosemary.shopEase.controller;

import com.aiyanyorrosemary.shopEase.entities.Order;
import com.aiyanyorrosemary.shopEase.entities.Product;
import com.aiyanyorrosemary.shopEase.services.OrderService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    //private static final Logger log = (Logger) LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;


    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(
                order.getCustomer()
                        .getId(),
                order.getProducts()
                        .stream()
                        .map(Product::getId)
                        .toList());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Order>> getAllOrders(@PathVariable Long customerId) {
        List<Order> orders = orderService.getAllOrders(customerId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
        return new ResponseEntity<>("Order cancelled successfully", HttpStatus.OK);
    }

}
