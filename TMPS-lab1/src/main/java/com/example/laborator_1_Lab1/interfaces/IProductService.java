package com.example.laborator_1_Lab1.interfaces;

import com.example.laborator_1_Lab1.App.Product;

import java.util.List;

public interface IProductService {
    void createProduct(String categoryTitle, String productName, String productDescription, double productPrice);
    List<Product> listProductsInCategory(String categoryTitle);
}
