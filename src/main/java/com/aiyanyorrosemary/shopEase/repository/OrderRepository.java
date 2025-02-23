package com.aiyanyorrosemary.shopEase.repository;

import com.aiyanyorrosemary.shopEase.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
