package com.vinithecsar.spring_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinithecsar.spring_store.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
