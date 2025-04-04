package com.aiyanyorrosemary.shopEase.controller;

import com.aiyanyorrosemary.shopEase.dto.CustomerDto;
import com.aiyanyorrosemary.shopEase.entities.Customer;
import com.aiyanyorrosemary.shopEase.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
   // private static final Logger log = (Logger) LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> registerCustomer(@RequestBody CustomerDto customerRequest) {
       // log.info("Adding customer {}", customerRequest.toString());

        Customer registeredCustomer = customerService.registerCustomer(customerRequest);
        return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
    }


    public ResponseEntity<List<Customer>> getAllProducts() {

        List<Customer> customers = customerService.viewAllCustomers();

        return new ResponseEntity<>(customers, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);


    }
}