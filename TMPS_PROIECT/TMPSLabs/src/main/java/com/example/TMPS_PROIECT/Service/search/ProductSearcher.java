package com.example.TMPS_PROIECT.Service.search;

import com.example.TMPS_PROIECT.App.Product;
import com.example.TMPS_PROIECT.interfaces.SearchStrategy;

import java.util.List;

public class ProductSearcher {
    private SearchStrategy searchStrategy;

    public ProductSearcher(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public List<Product> searchProducts(String keyword, List<Product> productList) {
        return searchStrategy.search(keyword, productList);
    }
}
