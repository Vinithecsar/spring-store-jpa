package com.vinithecsar.spring_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinithecsar.spring_store.entities.OrderItem;
import com.vinithecsar.spring_store.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
