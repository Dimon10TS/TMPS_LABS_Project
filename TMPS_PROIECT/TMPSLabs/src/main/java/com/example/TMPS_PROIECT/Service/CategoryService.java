package com.example.TMPS_PROIECT.Service;

import com.example.TMPS_PROIECT.App.Category;
import com.example.TMPS_PROIECT.App.Product;
import com.example.TMPS_PROIECT.interfaces.CategoryObserver;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private List<Category> categories;
    private List<CategoryObserver> observers;



    public void addCategory(Category category) {
        categories.add(category);
        notifyObservers();
    }


    public CategoryService() {
        categories = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void removeCategory(Category category) {
        categories.remove(category);
        notifyObservers();
        for (Product product : category.getProducts()) {
            product.setCategory(null);
        }
    }


    public void modifyCategoryTitle(Category category, String newTitle) {
        category.setTitle(newTitle);
        notifyObservers();
    }

    public List<Category> getCategories() {
        return categories;

    }

    public Category getCategoryByName(String categoryName) {
        for (Category category : categories) {
            if (category.getTitle().equals(categoryName)) {
                return category;
            }
        }
        return null;
    }

    public void addObserver(CategoryObserver observer) {
        observers.add(observer);
    }


    private void notifyObservers() {
        for (CategoryObserver observer : observers) {
            observer.update(categories);
        }
    }

}

