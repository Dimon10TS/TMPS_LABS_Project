package com.example.TMPS_PROIECT.App;

import com.example.TMPS_PROIECT.interfaces.ProductInterface;
import com.example.TMPS_PROIECT.interfaces.Wishlist;

import java.util.ArrayList;
import java.util.List;

public class User implements Wishlist {
    private String name;
    private List<ProductInterface> wishlist;

    public User(String name) {
        this.name = name;
        this.wishlist = new ArrayList<>();
    }

    public void addProductToWishlist(ProductInterface product) {
        wishlist.add(product);
        System.out.println("Produsul " + product.getName() + " a fost adăugat în lista de dorințe a utilizatorului " + name);
    }

    public void removeProductFromWishlist(ProductInterface product) {
        wishlist.remove(product);
        System.out.println("Produsul " + product.getName() + " a fost eliminat din lista de dorințe a utilizatorului " + name);
    }

    public void displayWishlist() {
        System.out.println("Lista de dorințe a utilizatorului " + name + ":");
        for (ProductInterface product : wishlist) {
            System.out.println(product.getName());
        }


    }
}