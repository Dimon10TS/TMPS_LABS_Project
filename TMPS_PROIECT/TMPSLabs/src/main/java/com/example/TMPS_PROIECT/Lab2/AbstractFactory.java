package com.example.TMPS_PROIECT.Lab2;


import com.example.TMPS_PROIECT.App.Category;
import com.example.TMPS_PROIECT.App.Product;

public abstract class AbstractFactory {
    public abstract Category createCategory(String title);
    public abstract Product createProduct(String name, String description, double price);
}