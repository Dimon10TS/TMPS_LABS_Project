package com.example.TMPS_PROIECT.Lab3;

import com.example.TMPS_PROIECT.interfaces.ProductInterface;
public abstract class ProductImpl implements ProductInterface {
    private String name;
    private String description;
    private double price;

    public ProductImpl(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void addToWishlist() {
        System.out.println("Produsul " + name + " a fost adăugat în lista de dorințe.");
    }

    public String getName() {
        return name;
    }
}
