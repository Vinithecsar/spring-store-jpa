package com.vinithecsar.spring_store.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinithecsar.spring_store.entities.Category;
import com.vinithecsar.spring_store.services.CategoryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

  private CategoryService categoryService;

  public CategoryResource(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  public ResponseEntity<List<Category>> findAll() {
    List<Category> list = categoryService.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Category> findById(@PathVariable Long id) {
    Category obj = categoryService.findById(id);

    return ResponseEntity.ok(obj);
  }

}
