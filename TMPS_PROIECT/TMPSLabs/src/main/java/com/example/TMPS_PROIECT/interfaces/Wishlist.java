package com.example.TMPS_PROIECT.interfaces;

import com.example.TMPS_PROIECT.App.Product;

import java.util.List;

public interface Wishlist {
    void addProductToWishlist(ProductInterface product);
    void removeProductFromWishlist(ProductInterface product);
    void displayWishlist();
}