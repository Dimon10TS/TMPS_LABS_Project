package com.example.TMPS_PROIECT.Lab3;

import com.example.TMPS_PROIECT.App.App;
import com.example.TMPS_PROIECT.App.Category;
import com.example.TMPS_PROIECT.App.Product;
import com.example.TMPS_PROIECT.App.User;
import com.example.TMPS_PROIECT.interfaces.ProductFactory;

import java.util.List;

public class AppFacade {
    private App app;
    private User user;

    public AppFacade() {
        this.app = new App(new ProductFactory());
        this.user = new User("John");
    }

    public void addProductToWishlist(String productName) {
        Category category = app.getCategoryByName("Electronice");
        user.addProductToWishlist(product);
    }

    public void removeProductFromWishlist(String productName) {
        Category category = app.getCategoryByName("Electronice");
        user.removeProductFromWishlist(product);
    }

    public void displayUserWishlist() {
        user.displayWishlist();
    }

    // Alte metode de accesare a funcționalităților aplicației

    // Metoda pentru afișarea listei de categorii
    public List<Category> getCategories() {
        return app.getCategories();
    }

    // Metoda pentru obținerea listei de produse dintr-o anumită categorie, sortate după nume
    public List<Product> getProductsSortedByName(String categoryName) {
        Category category = app.getCategoryByName(categoryName);
        return app.getProductsSortedByName(category);
    }

    // Metoda pentru obținerea listei de produse dintr-o anumită categorie, sortate după preț
    public List<Product> getProductsSortedByPrice(String categoryName) {
        Category category = app.getCategoryByName(categoryName);
        return app.getProductsSortedByPrice(category);
    }
}
