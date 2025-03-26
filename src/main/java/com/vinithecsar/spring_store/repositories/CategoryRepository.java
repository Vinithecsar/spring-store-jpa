package com.vinithecsar.spring_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinithecsar.spring_store.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
