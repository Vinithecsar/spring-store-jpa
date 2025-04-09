package com.vinithecsar.spring_store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.vinithecsar.spring_store.entities.User;
import com.vinithecsar.spring_store.repositories.UserRepository;
import com.vinithecsar.spring_store.services.exceptions.DatabaseException;
import com.vinithecsar.spring_store.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public User insert(User obj) {
    return userRepository.save(obj);
  }

  public void delete(Long id) {
    try {
      if (userRepository.existsById(id)) {
        userRepository.deleteById(id);
      } else {
        throw new ResourceNotFoundException(id);
      }
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseException(e.getMessage());
    }
  }

  public User update(Long id, User obj) {
    try {
      User entity = userRepository.getReferenceById(id);
      updateData(entity, obj);
      return userRepository.save(entity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException(id);
    }
  }

  private void updateData(User entity, User obj) {
    entity.setName(obj.getName());
    entity.setEmail(obj.getEmail());
    entity.setPhone(obj.getPhone());
  }
}
