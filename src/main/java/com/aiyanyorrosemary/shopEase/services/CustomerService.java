package com.aiyanyorrosemary.shopEase.services;

import com.aiyanyorrosemary.shopEase.dto.CustomerDto;
import com.aiyanyorrosemary.shopEase.entities.Customer;


import java.util.List;

public interface CustomerService {
    Customer registerCustomer(CustomerDto customer);
    List<Customer> viewAllCustomers();
    Customer getCustomerById(Long id);
    Customer updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);

}
