package com.vinithecsar.spring_store.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinithecsar.spring_store.entities.User;
import com.vinithecsar.spring_store.exceptions.ResourceNotFoundException;
import com.vinithecsar.spring_store.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  private UserService userService;

  public UserResource(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> list = userService.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    User obj = userService.findById(id);

    if (obj == null) {
      throw new ResourceNotFoundException("User with ID " + id + " not found");
    }

    return ResponseEntity.ok(obj);
  }

}
