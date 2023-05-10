# **Structural Design Paterns.**
___


În raportul dat sunt utilizate 4 tipuri de design patterns structurale:

• Decorator

• Facade

• Adapter

• Proxy

# Decorator

Design pattern-ul Decorator este un pattern structural care permite adăugarea de comportamente suplimentare la obiecte existente, fără a modifica structura acestora.
Idee generală:

1. Decoratorul utilizează o abordare de înveliș pentru a extinde funcționalitatea unui obiect de bază.
2. Atât obiectul de bază, cât și decoratorii implementează aceeași interfață sau clase abstracte, astfel încât să poată fi tratați în mod similar.
3. Decoratorii conțin o referință către obiectul de bază și îl înconjoară într-un mod transparent, permițând adăugarea sau modificarea comportamentului acestuia.
4. Pot fi adăugați mai mulți decoratori unul peste altul, formând o "înlănțuire" de obiecte înveliș.
___

In cadrul aplicatiei, am definit interfața Product,
care reprezintă obiectul de bază pe care dorim să-l decorăm.
Apoi, am creat clasa BaseProduct, care implementează interfața Product și reprezintă implementarea inițială a unui produs.

Am definit, de asemenea, clasa DiscountedProduct ca un decorator pentru Product,
adăugând funcționalitatea de reducere a prețului.
DiscountedProduct primește o referință la un obiect Product și îl înconjoară,
extinzând metoda getPrice() pentru a aplica o reducere.

Astfel, prin crearea și utilizarea unui decorator DiscountedProduct, putem adăuga funcționalitatea de reducere a prețului la un produs existent, fără a modifica clasa BaseProduct sau interfața Product. Acest lucru oferă o flexibilitate și
extensibilitate mai mare în ceea ce privește modificarea comportamentului produselor.
---
Exemplu:
```
// Decorator pentru produsele cu reducere de preț
public class DiscountedProduct implements Product {
    private Product product;
    private double discount;

    public DiscountedProduct(Product product, double discount) {
        this.product = product;
        this.discount = discount;
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

// Utilizarea decoratorului pentru a crea un produs cu reducere de preț
Product baseProduct = new BaseProduct("Laptop ", "Laptop Lenovo", 20000);
Product discountedProduct = new DiscountedProduct(baseProduct, 0.1); 
// Reducere de 10%
////afisare
System.out.println("Nume: " + discountedProduct.getName()); 
System.out.println("Descriere: " + discountedProduct.getDescription()); 
System.out.println("Preț: " + discountedProduct.getPrice());  
```

___
Astfel, prin utilizarea clasei WishlistDecorator,
am obținut posibilitatea de a adăuga
funcționalități suplimentare
la obiectele de tip Wishlist
fără a modifica direct clasa de bază, ce va extinde
funcționalitatea unui obiect existent
prin împachetarea acestuia într-un decorator.
Idea de bază a unei liste de dorințe (Wishlist)
este de a permite utilizatorului
să-și gestioneze și
să-și monitorizeze
produsele sau obiectele pe care le dorește sau le consideră interesante,
ceea ce într-o mică măsură am putut realiza.

___

# **Facade**

```
public class AppFacade {
    private App app;
    private User user;

    public AppFacade() {
        this.app = new App(new ProductFactory());
        this.user = new User("John");
    }

    public void addProductToWishlist(String productName) {
        Category category = app.getCategoryByName("Electronice");
        Product product = app.getProductByNameAndCategory(productName, category);
        user.addProductToWishlist(product);
    }

    public void removeProductFromWishlist(String productName) {
        Category category = app.getCategoryByName("Electronice");
        Product product = app.getProductByNameAndCategory(productName, category);
        user.removeProductFromWishlist(product);
    }

    public void displayUserWishlist() {
        user.displayWishlist();
    }

 

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

```

În acest exemplu, clasa AppFacade reprezintă o interfață simplificată pentru utilizator și
ascunde detalii despre modul în care sunt gestionate
produsele, categoriile și lista de dorințe.
Utilizatorul poate utiliza această clasă pentru a adăuga și elimina produse din wishlist și pentru a afișa lista de dorințe. Clasa AppFacade utilizează clasele App și User pentru a implementa funcționalitățile corespunzătoare.

Prin utilizarea design pattern-ului Facade, codul de apel pentru funcționalitățile aplicației este simplificat și unificat prin intermediul clasei Facade,
oferind o interfață coerentă și
ușor de utilizat pentru utilizator.

___

**Prin utilizarea design pattern-ului Facade, codul de apel pentru funcționalitățile aplicației este simplificat,
oferind o interfață coerentă și ușor de utilizat pentru utilizator.**

___

# **Adapter**

___

Adaptorul este un model de design structural care permite obiectelor cu interfețe incompatibile să colaboreze.
```
public interface ProductAdapter {
    String getProductName();
    double getProductPrice();
}
```
```
public class ProductAdapterImpl implements ProductAdapter {
    private Product product;

    public ProductAdapterImpl(Product product) {
        this.product = product;
    }

    public String getProductName() {
        return product.getName();
    }

    public double getProductPrice() {
        return product.getPrice();
    }
}

```
```
  Product televizor= new Product("Televizor", 20000);
  ProductAdapter adapter = new ProductAdapterImpl(televizor);

System.out.println("Product Name: " + adapter.getProductName());
System.out.println("Product Price: " + adapter.getProductPrice());
```
În acest exemplu,
prin intermediul adaptorului ProductAdapterImpl,
putem accesa metodele getProductName() și getProductPrice() pentru a obține numele și prețul produsului televizor,
în ciuda faptului că Product nu implementează direct interfața ProductAdapter.
Adaptorul se ocupă de conversia între cele două interfețe și expune metodele dorite pentru utilizare.

___

# Proxy
___

Proxy-ul este un design pattern structural care permite crearea unui obiect intermediar care controlează accesul la un alt obiect. Acesta acționează ca o înlocuire sau o reprezentare a obiectului real și oferă o interfață similară prin care se poate accesa obiectul real.

Proxy-ul acționează ca o barieră între client și obiectul real, controlând și gestionând accesul la acesta. Clientul interacționează cu proxy-ul în mod similar cu obiectul real, fără a fi conștient de existența proxy-ului sau a restricțiilor pe care le poate impune.

```package com.example.TMPS_PROIECT.Lab3;

import com.example.TMPS_PROIECT.App.Category;
import com.example.TMPS_PROIECT.App.Product;
import com.example.TMPS_PROIECT.App.User;
import com.example.TMPS_PROIECT.Main.exceptii.UnauthorizedAccessException;
import com.example.TMPS_PROIECT.Service.ProductService;

import java.util.List;

public class ProductServiceProxy extends ProductService {
    private ProductService productService;
    private User user;

    public ProductServiceProxy(Category category) {
        super(category);
    }

    public void addProduct(Product product) {
        if (user.isAdmin()) {
            productService.addProduct(product);
        } else {
            throw new UnauthorizedAccessException("Numai administratorii au permisiunea de a adăuga produse.");
        }
    }

    public void deleteProduct(Product product) {
        if (user.isAdmin()) {
            productService.deleteProduct(product);
        } else {
            throw new UnauthorizedAccessException("Numai administratorii au permisiunea de a șterge produse.");
        }
    }

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
```
Daca utilizatorul este conectat ca admin, el va putea adauga
produse sau sa le stearga.
În caz contrar, se aruncă o excepție UnauthorizedAccessException pentru a indica că utilizatorul nu are permisiunea de a efectua operația respectivă.

Astfel, prin intermediul design pattern-ului Proxy, putem impune limite utilizatorilor și le putem  oferi acces restricționat la anumite operații în funcție de rolul sau privilegiile lor.

