package com.example.TMPS_PROIECT.Lab2;

import com.example.TMPS_PROIECT.App.Category;
import com.example.TMPS_PROIECT.App.Product;

public class CategoryFactory extends AbstractFactory {
    @Override
    public Category createCategory(String title) {
        return new Category(title);
    }

    @Override
    public Product createProduct(String name, String description, double price) {
        return null; // Not implemented for this factory
    }
}
