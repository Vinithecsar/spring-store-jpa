package com.vinithecsar.spring_store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vinithecsar.spring_store.entities.User;
import com.vinithecsar.spring_store.repositories.UserRepository;

@Service
public class UserService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(Long id) {
    Optional<User> obj = userRepository.findById(id);
    return obj.isPresent() ? obj.get() : null;
  }
}
