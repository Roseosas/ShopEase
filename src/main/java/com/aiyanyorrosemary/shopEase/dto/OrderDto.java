package com.aiyanyorrosemary.shopEase.dto;

import com.aiyanyorrosemary.shopEase.entities.Customer;
import com.aiyanyorrosemary.shopEase.entities.Product;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    private Customer customer;
    private List<Product> products;
    private LocalDateTime orderDate;

    public OrderDto(Customer customer, List<Product> products, LocalDateTime orderDate){
        this.customer = customer;
        this.orderDate = orderDate;
        this.products= products;
    }
    public OrderDto(){

    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
