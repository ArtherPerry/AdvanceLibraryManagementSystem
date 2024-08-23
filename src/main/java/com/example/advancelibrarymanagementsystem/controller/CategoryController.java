package com.example.advancelibrarymanagementsystem.controller;

import com.example.advancelibrarymanagementsystem.entitites.Category;
import com.example.advancelibrarymanagementsystem.exceptionHandling.ResourceNotFoundException;
import com.example.advancelibrarymanagementsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    private static final String CATEGORY_NOT_FOUND = "Category not found with id: ";

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        Optional<Category> category = categoryService.findCategoryById(id);
        if (category.isEmpty()) {
            throw new ResourceNotFoundException(CATEGORY_NOT_FOUND + id);
        }
        Category updatedCategory = categoryService.updateCategory(id, categoryDetails);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        Optional<Category> category = categoryService.findCategoryById(id);
        if (category.isEmpty()) {
            throw new ResourceNotFoundException(CATEGORY_NOT_FOUND + id);
        }
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.findCategoryById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY_NOT_FOUND + id));
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.findAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<Category>> getCategoryByName(@PathVariable String name) {
        Optional<Category> category = categoryService.findCategoryByName(name);
        if (category.isEmpty()) {
            throw new ResourceNotFoundException(CATEGORY_NOT_FOUND + name);
        }
        return ResponseEntity.ok(category);
    }
}