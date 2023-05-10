package com.example.laborator_1_Lab1.interfaces;


import com.example.laborator_1_Lab1.App.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getCategories();
    Category findCategory(String title);
    void createCategory(String title);
    void deleteCategory(String title);
    void modifyCategoryTitle(String oldTitle, String newTitle);
}