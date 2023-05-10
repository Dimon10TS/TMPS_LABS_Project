package com.example.TMPS_PROIECT.App;

import com.example.TMPS_PROIECT.interfaces.Cloneable;

public class Product implements Cloneable {

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String name;
    private String description;
    private double price;
    private Category category;
    private static Product instance = null;

    public Product(String name, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(String name, String description, double price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }


    @Override
    public String toString() {
        return String.format("%s, (%s): %.2f lei", name, description, price, category);
    }

}

