package com.example.TMPS_PROIECT.App;

import com.example.TMPS_PROIECT.Lab2.AbstractFactory;
import com.example.TMPS_PROIECT.Service.CategoryService;
import com.example.TMPS_PROIECT.Service.ProductService;
import com.example.TMPS_PROIECT.interfaces.CategoryObserver;

import java.util.ArrayList;
import java.util.List;

public class App {
    private CategoryService categoryService;
    private ProductService productService;
    private AbstractFactory factory;

    public App(AbstractFactory factory) {
        this.factory = factory;
        categoryService = new CategoryService();
        categoryService.addObserver((CategoryObserver) this);
    }

    public App() {

    }

    public Category addCategory(String title) {
        Category category = factory.createCategory(title);
        categoryService.addCategory(category);
        productService = new ProductService(category);
        return category;
    }


    public void modifyCategoryTitle(Category category, String newTitle) {
        categoryService.modifyCategoryTitle(category, newTitle);
    }

    public Product addProduct(String name, String description, double price, Category category1) {
        Product product = factory.createProduct(name, description, price);
        productService.addProduct(product);
        return product;
    }

    public void deleteProduct(Product product) {
        productService.deleteProduct(product);
    }

    public List<Product> getProductsSortedByName(Category category1) {
        return productService.getProductsSortedByName();
    }

    public List<Product> getProductsSortedByPrice(Category category2) {
        return productService.getProductsSortedByPrice();
    }

    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    public List<Product> getProductsByCategoryName(String categoryName) {
        Category category = categoryService.getCategoryByName(categoryName);
        if (category != null) {
            return category.getProducts();
        } else {
            return new ArrayList<>();
        }
    }

}
