package com.aiyanyorrosemary.shopEase.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
private Customer customer;
@ManyToMany
private List<Product> products;
private LocalDateTime orderDate;

    public Order(Long id, Customer customer,List<Product> products, LocalDateTime orderDate) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.orderDate= orderDate;
    }

    public Order() {
    }

    public static Order.OrderBuilder builder() {
        return new Order.OrderBuilder();
    }
    public Long getId() {
        return this.id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    public void setId(Long id) {
        this.id = id;
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

    public static class OrderBuilder {
        private Long id;
        private Customer customer;
        private List<Product> products;
        private LocalDateTime orderDate;

        OrderBuilder() {
        }

        public Order.OrderBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Order.OrderBuilder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Order.OrderBuilder products(List<Product> products) {
            this.products = products;
            return this;
        }

        public Order.OrderBuilder orderBuilder(LocalDateTime orderDate) {
            this.orderDate = orderDate;
            return this;
        }

       // public Order build() {
         //   return new Customer(this.id, this.customer, this.products, this.orderDate);
       // }

        public String toString() {
            return "Order.OrderBuilder(id=" + this.id + ", customer=" + this.customer + ", products=" + this.products + ", orderDate=" + this.orderDate + ")";
        }
    }
}
