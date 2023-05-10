package com.example.TMPS_PROIECT.App;

import com.example.TMPS_PROIECT.interfaces.Cloneable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Category implements Cloneable {

    private String title;
    private List<Product> products;

    public Category(String title) {
        this.title = title;
        this.products = new ArrayList<>();
    }

    public Category(Category title) {
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
        product.setCategory(null);
    }

    public List<Product> getProducts() {
        return products;
    }
    @Override
    public String toString() {
        return title;
    }

    public List<Product> getProductsSortedByName() {
        List<Product> sortedProducts = new ArrayList<>(products);
        Collections.sort(sortedProducts, Comparator.comparing(Product::getName));
        return sortedProducts;
    }

    public List<Product> getProductsSortedByPrice() {
        List<Product> sortedProducts = new ArrayList<>(products);
        Collections.sort(sortedProducts, Comparator.comparing(Product::getPrice));
        return sortedProducts;
    }
    @Override
    public Object clone() {
        try {
            Category category = (Category) super.clone();
            category.products = new ArrayList<>(this.products); // se clonaza si lista de produse
            return category;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addCategory(String electronice) {
    }
}
