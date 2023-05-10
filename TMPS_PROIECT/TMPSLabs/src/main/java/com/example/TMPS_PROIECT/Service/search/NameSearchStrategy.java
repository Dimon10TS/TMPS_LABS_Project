package com.example.TMPS_PROIECT.Service.search;

import com.example.TMPS_PROIECT.App.Product;
import com.example.TMPS_PROIECT.interfaces.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class NameSearchStrategy implements SearchStrategy {
    public List<Product> search(String keyword, List<Product> productList) {
        List<Product> foundProducts = new ArrayList<>();

        for (Product product : productList) {
            if (product.getName().contains(keyword)) {
                foundProducts.add(product);
            }
        }

        return foundProducts;
    }
}
