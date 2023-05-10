package com.example.TMPS_PROIECT.Main;

import com.example.TMPS_PROIECT.App.*;
import com.example.TMPS_PROIECT.Lab2.CategoryFactory;
import com.example.TMPS_PROIECT.Lab3.DiscountedProduct;
import com.example.TMPS_PROIECT.Lab3.ProductAdapterImpl;
import com.example.TMPS_PROIECT.Lab3.ProductImpl;
import com.example.TMPS_PROIECT.Role.Role;
import com.example.TMPS_PROIECT.Role.RoleList;
import com.example.TMPS_PROIECT.Service.search.DescriptionSearchStrategy;
import com.example.TMPS_PROIECT.Service.search.NameSearchStrategy;
import com.example.TMPS_PROIECT.Service.search.ProductSearcher;
import com.example.TMPS_PROIECT.interfaces.ProductAdapter;
import com.example.TMPS_PROIECT.interfaces.ProductFactory;
import com.example.TMPS_PROIECT.interfaces.ProductInterface;
import com.example.TMPS_PROIECT.interfaces.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        // Crearea instanței clasei App folosind ProductFactory
        App app = new App(new ProductFactory());
        App app = new App(new CategoryFactory());


        // Adăugarea unei categorii
        Category category1 = app.addCategory("Electronice");
        Category category2 = app.addCategory("Haine");

        // Adăugarea unor produse

        // Adăugarea unor produse
        ProductInterface laptop = new ProductImpl("Laptop Dell", "Laptop Dell cu procesor i5", 2000);
        ProductInterface telefon = new ProductImpl("Telefon Samsung", "Telefon Samsung Galaxy S20", 3000);
        ProductInterface televizor = new ProductImpl("Televizor LG", "Televizor LG Smart TV", 4000);



        // Afisăm lista de categorii
        System.out.println("Lista de categorii:");
        List<Category> categories = app.getCategories();
        for (Category category : categories) {
            System.out.println(category);
        }
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("-----------------Sortare dupa nume---------------------");

        // Afisăm lista de produse din categoria "Electronice", sortată după nume
        System.out.println("Lista de produse din categoria \"Electronice\", sortata după nume:");
        List<Product> productsByName = app.getProductsSortedByName(category1);
        for (Product product : productsByName) {
            System.out.println(product);
        }
        System.out.println();
        System.out.println("---------------Sortare dupa Nume ----------------------");

        // Afisăm lista de produse din categoria "Haine", sortată după preț

        System.out.println("---------------Sortare dupa Pret ----------------------");

        System.out.println("Lista de produse din categoria \"Haine\", sortata dupa pret:");
        List<Product> productsByPrice = app.getProductsSortedByPrice(category2);
        for (Product product : productsByPrice) {
            System.out.println(product);
        }
        System.out.println();
        System.out.println("---------------Sortare dupa Pret ----------------------");


        //modificam categoria
        app.modifyCategoryTitle(category2, "sport");

        // Afisăm lista de categorii actualizată
        System.out.println("Lista de categorii actualizată:");
        categories = app.getCategories();
        for (Category category : categories) {
            System.out.println(category);
        }
        System.out.println();


        System.out.println("Lista de categorii actualizată:");
        categories = app.getCategories();
        for (Category category : categories) {
            System.out.println(category);
        }


        System.out.println("Lista de categorii actualizată:");
        categories = app.getCategories();
        for (Category category : categories) {
            System.out.println(category);
        }

        // Obținem lista de produse pentru o anumită categorie
        String categoryName = "Electronice";
        System.out.println("Lista de produse pentru categoria \"" + categoryName + "\":");
        List<Product> products = app.getProductsByCategoryName(categoryName);
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println();



        // cautarea produselor dupa nume
        SearchStrategy nameSearchStrategy = new NameSearchStrategy();
        ProductSearcher nameSearcher = new ProductSearcher(nameSearchStrategy);
        List<Product> foundProductsByName = nameSearcher.searchProducts("Samsung", products);

        // cautarea produselor dupa descriere
        SearchStrategy descriptionSearchStrategy = new DescriptionSearchStrategy();
        ProductSearcher descriptionSearcher = new ProductSearcher(descriptionSearchStrategy);
        List<Product> foundProductsByDescription = descriptionSearcher.searchProducts("procesor", products);

        // afisarea produselor gasite
        printProducts(foundProductsByName);
        printProducts(foundProductsByDescription);
    }

    public static void printProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getDescription() + " - " + product.getPrice());
        }
    }

    private Category app;
    Product laptop = app.addProduct("Laptop Dell", "Laptop Dell cu procesor i5", 2000, category1);
    Product laptopClone = (Product) laptop.clone();

    // Adăugarea unor produse

    // Crearea utilizatorului
       User user = new User("John");

    // Adăugarea produselor în lista de dorințe a utilizatorului
        user.addProductToWishlist("laptop");
        user.addProductToWishlist("telefon");
        user.addProductToWishlist("televizor");

    // Afisarea listei de dorințe a utilizatorului
        user.displayWishlist();


    // Utilizarea decoratorului pentru a crea un produs cu reducere de preț
    /*Product baseProduct = new BaseProduct("Laptop Dell", "Laptop Dell cu procesor i5", 2000);
    Product discountedProduct = new DiscountedProduct(baseProduct, 0.1); // Reducere de 10%

         System.out.println("Nume: " + discountedProduct.getName());
         System.out.println("Descriere: " + discountedProduct.getDescription());
         System.out.println("Preț: " + discountedProduct.getPrice()); // Va afișa 1800 (10% reducere)

  */


    Product televizor= new Product("Televizor", 20000);
    ProductAdapter adapter = new ProductAdapterImpl(laptop);

System.out.println("Product Name: " + adapter.getProductName());
System.out.println("Product Price: " + adapter.getProductPrice());

       List<Role> roles = new ArrayList<>();
        roles.add(new Role("Admin"));
        roles.add(new Role("User"));

    RoleList roleList = new RoleList(roles);
        while (roleList.hasNext()) {
        Role role = roleList.next();
        role.performAction();
    }
}

