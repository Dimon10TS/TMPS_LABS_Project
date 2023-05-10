package com.example.TMPS_PROIECT.Lab3;

import com.example.TMPS_PROIECT.interfaces.ProductInterface;
import com.example.TMPS_PROIECT.interfaces.Wishlist;

import java.util.ArrayList;
import java.util.List;

class WishlistDecorator implements Wishlist {
    private Wishlist wishlist;
    private List<ProductInterface> products;

    public WishlistDecorator(Wishlist wishlist) {
        this.wishlist = wishlist;
        this.products = new ArrayList<>();
    }

    public void addProductToWishlist(ProductInterface product) {
        wishlist.addProductToWishlist(product);
        products.add(product);
    }

    public void removeProductFromWishlist(ProductInterface product) {
        wishlist.removeProductFromWishlist(product);
        products.remove(product);
    }

    public void displayWishlist() {
        wishlist.displayWishlist();
        System.out.println("Produse adăugate în wishlist:");
        for (ProductInterface product : products) {
            System.out.println(product.getName());
        }
    }
}
