package com.example.TMPS_PROIECT.Lab2;

import com.example.TMPS_PROIECT.App.Category;
import com.example.TMPS_PROIECT.App.Product;

public class ProductFactory extends AbstractFactory {
    @Override
    public Category createCategory(String title) {
        return null;
    }

    @Override
    public Product createProduct(String name, String description, double price) {
        return new Product(name, description, price);
    }
}