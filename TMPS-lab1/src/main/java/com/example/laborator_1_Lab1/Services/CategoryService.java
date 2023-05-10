package com.example.laborator_1_Lab1.Services;

import com.example.laborator_1_Lab1.App.Category;
import com.example.laborator_1_Lab1.interfaces.ICategoryRepository;
import com.example.laborator_1_Lab1.interfaces.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.getCategories();
    }

    @Override
    public Category findCategory(String title) {
        return categoryRepository.findCategory(title);
    }

    @Override
    public void createCategory(String title) {
        Category category = new Category(title);
        categoryRepository.addCategory(category);
    }

    @Override
    public void deleteCategory(String title) {
        Category category = categoryRepository.findCategory(title);
        categoryRepository.deleteCategory(category);
    }

    @Override
    public void modifyCategoryTitle(String oldTitle, String newTitle) {
        Category category = categoryRepository.findCategory(oldTitle);
        category.setTitle(newTitle);
    }
}
