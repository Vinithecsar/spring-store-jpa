package com.vinithecsar.spring_store.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinithecsar.spring_store.entities.Product;
import com.vinithecsar.spring_store.services.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

  private ProductService productService;

  public ProductResource(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    List<Product> list = productService.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    Product obj = productService.findById(id);

    return ResponseEntity.ok(obj);
  }

}
