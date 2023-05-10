package com.example.TMPS_PROIECT.Service;

import com.example.TMPS_PROIECT.App.Category;
import com.example.TMPS_PROIECT.App.Product;
import com.example.TMPS_PROIECT.interfaces.SortStrategy;
import com.example.TMPS_PROIECT.Service.sort.SortByNameStrategy;
import com.example.TMPS_PROIECT.Service.sort.SortByPriceStrategy;

import java.util.List;

public class ProductService {
    private Category category;

    public ProductService(Category category) {
        this.category = category;
    }

    public void addProduct(Product product) {
        category.addProduct(product);
    }

    public void deleteProduct(Product product) {
        category.deleteProduct(product);
    }

    public List<Product> getProductsSortedByName() {
        List<Product> products = category.getProducts();
        SortStrategy sortStrategy = new SortByNameStrategy();
        sortStrategy.sort(products);
        return products;
    }

    public List<Product> getProductsSortedByPrice() {
        List<Product> products = category.getProducts();
        SortStrategy sortStrategy = new SortByPriceStrategy();
        sortStrategy.sort(products);
        return products;
    }




}

