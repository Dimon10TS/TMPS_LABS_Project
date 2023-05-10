package com.example.TMPS_PROIECT.Lab3;

import com.example.TMPS_PROIECT.App.Category;
import com.example.TMPS_PROIECT.App.Product;
import com.example.TMPS_PROIECT.App.User;
import com.example.TMPS_PROIECT.Main.exceptii.UnauthorizedAccessException;
import com.example.TMPS_PROIECT.Service.ProductService;

import java.util.List;

public class ProductServiceProxy extends ProductService {
    private ProductService productService;
    private User user;

    public ProductServiceProxy(Category category) {
        super(category);
    }

    public void addProduct(Product product) {
        if (user.isAdmin()) {
            productService.addProduct(product);
        } else {
            throw new UnauthorizedAccessException("Numai administratorii au permisiunea de a adăuga produse.");
        }
    }

    public void deleteProduct(Product product) {
        if (user.isAdmin()) {
            productService.deleteProduct(product);
        } else {
            throw new UnauthorizedAccessException("Numai administratorii au permisiunea de a șterge produse.");
        }
    }

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}