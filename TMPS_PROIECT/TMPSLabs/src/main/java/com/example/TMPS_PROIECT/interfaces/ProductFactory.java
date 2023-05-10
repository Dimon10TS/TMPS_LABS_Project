package com.example.TMPS_PROIECT.interfaces;

import com.example.TMPS_PROIECT.App.Product;

public interface ProductFactory {
    Product createProduct(String name, String description, double price);
}
