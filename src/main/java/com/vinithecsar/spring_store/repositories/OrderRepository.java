package com.vinithecsar.spring_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinithecsar.spring_store.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
