package com.vinithecsar.spring_store.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vinithecsar.spring_store.entities.Order;
import com.vinithecsar.spring_store.entities.User;
import com.vinithecsar.spring_store.entities.enums.OrderStatus;
import com.vinithecsar.spring_store.repositories.OrderRepository;
import com.vinithecsar.spring_store.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  private UserRepository userRepository;
  private OrderRepository orderRepository;

  public TestConfig(UserRepository userRepository, OrderRepository orderRepository) {
    this.userRepository = userRepository;
    this.orderRepository = orderRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    User u1 = new User(null, "Jane Doe", "jane@gmail.com", "912345678", "123456");
    User u2 = new User(null, "John Doe", "john@gmail.com", "987654321", "123456");

    Order o1 = new Order(null, Instant.parse("2024-02-20T19:53:07Z"), OrderStatus.PAID, u1);
    Order o2 = new Order(null, Instant.parse("2024-03-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
    Order o3 = new Order(null, Instant.parse("2024-03-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

    userRepository.saveAll(Arrays.asList(u1, u2));
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
  }
}
