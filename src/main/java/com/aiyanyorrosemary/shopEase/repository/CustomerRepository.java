package com.aiyanyorrosemary.shopEase.repository;

import com.aiyanyorrosemary.shopEase.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
