package com.vinithecsar.spring_store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vinithecsar.spring_store.entities.User;
import com.vinithecsar.spring_store.repositories.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;

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

  public User insert(User obj) {
    return userRepository.save(obj);
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }

  public User update(Long id, User obj) {
    User entity = userRepository.getReferenceById(id);
    updateData(entity, obj);
    return userRepository.save(entity);
  }

  private void updateData(User entity, User obj) {
    entity.setName(obj.getName());
    entity.setEmail(obj.getEmail());
    entity.setPhone(obj.getPhone());
  }
}
