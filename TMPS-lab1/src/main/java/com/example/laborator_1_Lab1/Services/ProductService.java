package com.example.laborator_1_Lab1.Services;

import com.example.laborator_1_Lab1.App.Product;
import com.example.laborator_1_Lab1.interfaces.ICategoryRepository;
import com.example.laborator_1_Lab1.interfaces.IProductService;
import jdk.jfr.Category;

import java.util.List;

public class ProductService implements IProductService {
    private ICategoryRepository categoryRepository;

    public ProductService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createProduct(String categoryTitle, String productName, String productDescription, double productPrice) {
        Category category = categoryRepository.findCategory(categoryTitle);
        Product product = new Product(productName, productDescription, productPrice);
        category.createProduct(product);
    }

    @Override
    public List<Product> listProductsInCategory(String categoryTitle) {
        Category category = CategoryService.findCategory(categoryTitle);
        return category.getProducts();
    }
}