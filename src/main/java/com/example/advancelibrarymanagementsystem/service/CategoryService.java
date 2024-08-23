package com.example.advancelibrarymanagementsystem.service;

import com.example.advancelibrarymanagementsystem.entitites.Category;
import com.example.advancelibrarymanagementsystem.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id,Category category){
        category.setId(id);
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public Optional<Category> findCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    public List<Category> findAllCategories(){
       return categoryRepository.findAll();
    }

    public Optional<Category> findCategoryByName(String name){
        return categoryRepository.findByName(name);
    }


}
