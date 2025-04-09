package com.vinithecsar.spring_store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vinithecsar.spring_store.entities.Order;
import com.vinithecsar.spring_store.repositories.OrderRepository;
import com.vinithecsar.spring_store.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  public Order findById(Long id) {
    Optional<Order> obj = orderRepository.findById(id);
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }
}
