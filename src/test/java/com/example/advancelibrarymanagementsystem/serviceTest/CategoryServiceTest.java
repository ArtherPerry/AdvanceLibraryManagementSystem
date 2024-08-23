package com.example.advancelibrarymanagementsystem.serviceTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.advancelibrarymanagementsystem.entitites.Category;
import com.example.advancelibrarymanagementsystem.repo.CategoryRepository;
import com.example.advancelibrarymanagementsystem.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.List;

@SpringBootTest
 class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCategory() {
        Category category = new Category();
        when(categoryRepository.save(category)).thenReturn(category);

        Category result = categoryService.saveCategory(category);
        assertEquals(category, result);
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void testUpdateCategory() {
        Category category = new Category();
        category.setId(1L);
        when(categoryRepository.save(category)).thenReturn(category);

        Category result = categoryService.updateCategory(1L, category);
        assertEquals(1L, result.getId());
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void testDeleteCategory() {
        doNothing().when(categoryRepository).deleteById(1L);
        categoryService.deleteCategory(1L);
        verify(categoryRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindCategoryById() {
        Category category = new Category();
        category.setId(1L);
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        Optional<Category> result = categoryService.findCategoryById(1L);
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testFindAllCategories() {
        categoryService.findAllCategories();
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void testFindCategoryByName() {
        Category category = new Category();
        when(categoryRepository.findByName("Fiction")).thenReturn(Optional.of(category));

        Optional<Category> result = categoryService.findCategoryByName("Fiction");
        assertEquals(category, result.get());
    }
}