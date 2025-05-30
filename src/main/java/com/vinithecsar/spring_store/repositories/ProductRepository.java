package com.vinithecsar.spring_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinithecsar.spring_store.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
