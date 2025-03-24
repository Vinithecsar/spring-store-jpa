package com.vinithecsar.spring_store.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vinithecsar.spring_store.entities.User;
import com.vinithecsar.spring_store.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  private UserRepository userRepository;

  public TestConfig(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    User u1 = new User(null, "Jane Doe", "jane@gmail.com", "912345678", "123456");
    User u2 = new User(null, "John Doe", "john@gmail.com", "987654321", "123456");

    userRepository.saveAll(Arrays.asList(u1, u2));
  }
}
