package com.vinithecsar.spring_store.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinithecsar.spring_store.entities.Order;
import com.vinithecsar.spring_store.exceptions.ResourceNotFoundException;
import com.vinithecsar.spring_store.services.OrderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

  private OrderService orderService;

  public OrderResource(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping
  public ResponseEntity<List<Order>> findAll() {
    List<Order> list = orderService.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Order> findById(@PathVariable Long id) {
    Order obj = orderService.findById(id);

    if (obj == null) {
      throw new ResourceNotFoundException("Order with ID " + id + " not found");
    }

    return ResponseEntity.ok(obj);
  }

}
