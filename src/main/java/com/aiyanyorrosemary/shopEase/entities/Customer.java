package com.aiyanyorrosemary.shopEase.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public Customer() {
    }

    public Customer(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    public static Customer.CustomerBuilder builder() {
        return new Customer.CustomerBuilder();
    }
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public static class CustomerBuilder {
        private Long id;
        private String name;
        private String email;

        CustomerBuilder() {
        }
        public CustomerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder email(String email) {
            this.email = email;
            return this;
        }


        public Customer build() {
            return new Customer(this.id, this.name, this.email);
        }

        public String toString() {
            return "Customer.CustomerBuilder(id=" + this.id + ", name=" + this.name + ", description=" + ", email=" + this.email + ")";
        }
    }
}


