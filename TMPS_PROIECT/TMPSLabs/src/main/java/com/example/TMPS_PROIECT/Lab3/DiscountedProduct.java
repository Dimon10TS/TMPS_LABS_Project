package com.example.TMPS_PROIECT.Lab3;

import com.example.TMPS_PROIECT.App.Product;
import com.example.TMPS_PROIECT.interfaces.ProductInterface;

// Decorator pentru produsele cu reducere de preț
public class DiscountedProduct implements ProductInterface {
    private Product product;
    private double discount;

    public DiscountedProduct(Product product, double discount) {
        this.product = product;
        this.discount = discount;
    }

    @Override
    public void addToWishlist() {

    }

    public String getName() {
        return product.getName() + " (Discounted)";
    }

    public String getDescription() {
        return product.getDescription();
    }

    public double getPrice() {
        double discountedPrice = product.getPrice() * (1 - discount);
        return discountedPrice;
    }
}