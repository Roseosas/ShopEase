package com.aiyanyorrosemary.shopEase.services.Implementation;

import com.aiyanyorrosemary.shopEase.dto.CustomerDto;
import com.aiyanyorrosemary.shopEase.entities.Customer;
import com.aiyanyorrosemary.shopEase.exception.ResourceNotFoundException;
import com.aiyanyorrosemary.shopEase.repository.CustomerRepository;
import com.aiyanyorrosemary.shopEase.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(CustomerDto customerRequest) {
        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .build();
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> viewAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        if (customerOpt.isPresent()) {
            return customerOpt.get();
        } else {
            throw new ResourceNotFoundException("Customer Does  Not Exist");
        }
    }
    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            customer.setName(customer.getName());
            customer.setEmail(customer.getEmail());
            return customerRepository.save(customer);
        }else {
            throw new ResourceNotFoundException("Customer Does  Not Exist");
        }
    }

    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Customer Does  Not Exist");
        }
    }
}
