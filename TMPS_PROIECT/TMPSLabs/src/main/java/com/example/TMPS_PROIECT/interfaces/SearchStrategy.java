package com.example.TMPS_PROIECT.interfaces;

import com.example.TMPS_PROIECT.App.Product;

import java.util.List;

public interface SearchStrategy {
    public List<Product> search(String keyword, List<Product> productList);
}