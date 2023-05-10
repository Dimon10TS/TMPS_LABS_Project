package com.example.TMPS_PROIECT.interfaces;

import com.example.TMPS_PROIECT.App.Product;

import java.util.List;

public interface SortStrategy {
    List<Product> sort(List<Product> products);
}
