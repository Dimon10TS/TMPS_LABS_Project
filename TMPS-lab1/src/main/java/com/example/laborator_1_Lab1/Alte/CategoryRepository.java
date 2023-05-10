// ICategoryRepository.java
package com.example.laborator_1_Lab1.Alte;

import com.example.laborator_1_Lab1.App.Category;
import com.example.laborator_1_Lab1.interfaces.ICategoryRepository;

import java.util.ArrayList;
import java.util.List;



public class CategoryRepository implements ICategoryRepository {
    private List<Category> categories;

    public CategoryRepository() {
        categories = new ArrayList<>();
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public Category findCategory(String title) {
        for (Category category : categories) {
            if (category.getTitle().equals(title)) {
                return category;
            }
        }
        return null;
    }

    @Override
    public void createCategory(Category category) {
        categories.add(category);
    }

    @Override
    public void deleteCategory(Category category) {
        categories.remove(category);
    }

    @Override
    public void updateCategory(Category category) {
        int index = categories.indexOf(category);
        if (index != -1) {
            categories.set(index, category);
        }
    }
}
