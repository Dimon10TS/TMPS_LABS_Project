package com.example.laborator_1_Lab1.interfaces;


import com.example.laborator_1_Lab1.App.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> getCategories();
    Category findCategory(String title);
    void addCategory(Category category);
    void deleteCategory(Category category);
    void updateCategory(Category category);
}