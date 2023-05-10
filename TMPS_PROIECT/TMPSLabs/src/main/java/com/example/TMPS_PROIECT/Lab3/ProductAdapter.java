package com.example.TMPS_PROIECT.Lab3;

import com.example.TMPS_PROIECT.App.Product;
import com.example.TMPS_PROIECT.interfaces.ProductAdapter;

public class ProductAdapterImpl implements ProductAdapter {
    private Product product;

    public ProductAdapterImpl(Product product) {
        this.product = product;
    }

    public String getProductName() {
        return product.getName();
    }

    public double getProductPrice() {
        return product.getPrice();
    }
}