package com.example.TMPS_PROIECT.Service.sort;

import com.example.TMPS_PROIECT.App.Product;
import com.example.TMPS_PROIECT.interfaces.SortStrategy;

import java.util.Comparator;
import java.util.List;

public class SortByPriceStrategy implements SortStrategy {
    @Override
    public List<Product> sort(List<Product> products) {
        Comparator<Product> byPrice = Comparator.comparingDouble(Product::getPrice);
        products.sort(byPrice);
        return products;
    }
}
