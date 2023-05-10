package com.example.TMPS_PROIECT.App;

import com.example.TMPS_PROIECT.interfaces.ProductInterface;

public abstract class BaseProduct implements ProductInterface {
    private String name;
    private String description;
    private double price;

    public BaseProduct(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}