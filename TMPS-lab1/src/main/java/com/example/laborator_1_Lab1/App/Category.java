package com.example.laborator_1_Lab1.App;


import java.util.ArrayList;
import java.util.List;

public class Category {
    private String title;
    private List<Product> products;

    public Category(String title) {
        this.title = title;
        this.products = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }
}

