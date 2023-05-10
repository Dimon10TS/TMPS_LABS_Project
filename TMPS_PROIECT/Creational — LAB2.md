# Creational Design Paterns
___


În raportul dat  sunt utilizate 4 tipuri de design patterns creationale:

• Singleton

• Abstract Factory

• Prototype

• Builder

# Singleton

Singleton este un model de design creațional 
care ne permite să ne asiguram că o clasă are o singură instanță, oferind
în același timp un punct de acces global la această instanță.

___
Principiul Singleton se referă 
la crearea unui obiect unic în întreaga aplicație 
și furnizează o modalitate convenabilă 
de accesare a acelui obiect din orice parte a aplicației. 
Pentru a implementa Singleton pe clasa Product,
trebuie să creăm o metodă statică getInstance() care să 
returneze instanța unică a clasei. 
```
public class Product {
    private static Product instance = null;
    private String name;
    private String description;
    private double price;

    private Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static Product getInstance(String name, String description, double price) {
        if (instance == null) {
            instance = new Product(name, description, price);
            return instance;
        }
        throw new IllegalStateException("Only one instance of Product can be created.");
    }

    // getters and setters

    @Override
    public String toString() {
        return String.format("%s (%s): %.2f lei", name, description, price);
    }
}

```
În acest exemplu, metoda getInstance 
verifică dacă instanța a fost deja creată,
 iar dacă da, aruncă o excepție IllegalStateException,
  altfel creează instanța și o returnează.Astfel, 
ca mentiune pot spune, daca vrem sa creem, ca si-n cazul
meu, mai multe produse, aici singletonul nu este rational, adica se 
contrazice total cu ideea de baza a singletonului.

___

    
_**Exemplu**_

Product p1 = Product.getInstance("Laptop", "Lenova", 4000.0);
System.out.println(p1);

// Încearcă să creeze o nouă instanță

Product p2 = Product.getInstance("Laptop", "ASUS", 2000.0);
// aruncă excepție

___

# Abstract Factory

Abstract Factory este un model de design creațional care ne permite să creiem familii 
de obiecte înrudite fără a specifica clasele lor concrete.

Pentru a implementa Abstract Factory, 
va trebui sa cream o clasa abstracta numita AbstractFactory
care va fi implementata de doua clase concrete de fabrica: 
ProductFactory si CategoryFactory. Clasa abstracta de fabrica 
va avea metode abstracte pentru a crea obiecte de tipul Product si Category.

```
package com.example.TMPS_PROIECT.Lab2;


import com.example.TMPS_PROIECT.App.Category;
import com.example.TMPS_PROIECT.App.Product;

public abstract class AbstractFactory {
    public abstract Category createCategory(String title);
    public abstract Product createProduct(String name, String description, double price);
}
```


Apoi se vor creia 2 clase. 
Clasa ProductFactory va implementa metodele pentru a crea obiecte de tipul Product, 
iar clasa CategoryFactory va implementa metodele pentru a crea obiecte de tipul Category.
```
package com.example.TMPS_PROIECT.App;

import com.example.TMPS_PROIECT.factory.AbstractFactory;
import com.example.TMPS_PROIECT.interfaces.CategoryObserver;

import java.util.ArrayList;
import java.util.List;

public class App {
    private CategoryService categoryService;
    private ProductService productService;
    private AbstractFactory factory;

    public App(AbstractFactory factory) {
        this.factory = factory;
        categoryService = new CategoryService();
        categoryService.addObserver((CategoryObserver) this);
    }

    public void addCategory(String title) {
        Category category = factory.createCategory(title);
        categoryService.addCategory(category);
        productService = new ProductService(category);
    }

    public void addProduct(String name, String description, double price) {
        Product product = factory.createProduct(name, description, price);
        productService.addProduct(product);
    }

}

```
Exemplu:
App app = new App(new ProductFactory()); // or new CategoryFactory() for categories

app.addCategory("Electronics");
app.addProduct("Laptop", "Lenovo, 5000.0);
List<Product> products = app.getProductsByCategoryName("Electronics");


___

# Prototype

Design pattern-ul Prototype este un pattern de creare,
care permite crearea de obiecte noi prin clonarea/copierea unui obiect existent, 
în loc de crearea unui obiect nou prin intermediul constructorului.
Acesta ajută la reducerea complexității creării obiectelor și la 
creșterea eficienței în ceea ce privește crearea și inițializarea lor.


În general, acest pattern este util atunci când avem nevoie să creăm obiecte similare, 
dar cu mici diferențe între ele. În loc să cream fiecare obiect separat, 
putem clona unul deja existent și să îi aducem modificările necesare, economisind astfel timp și memorie.

De asemenea, Prototype poate fi folosit și în situația în care crearea unui obiect
nou este o operație costisitoare (din punct de vedere al timpului sau al resurselor necesare). 
În acest caz, clonarea obiectului deja existent poate fi mult mai eficientă decât crearea unui obiect nou.

___


Pentru a adăuga designul de tipul prototype în aplicația noastră, am defenit o interfață pentru clonare
și  o implementăm în clasele care ar trebui să ofere această funcționalitate.
În acest fel, vom putea crea copii ale obiectelor existente, fără a fi nevoie să le creăm din nou și să inițializăm valorile lor.



```
//defenirea interfetei care va oferi metoda clone
public interface Cloneable {
public Object clone();
}

```

```
//defenirea interfetei care va oferi metoda clone
//Implementarea interfeței Cloneable în clasa Product, 
//astfel încât să oferim posibilitatea de a clona produse

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
   
```
```
//exemplu de clonare a unui produs//fix asa procedam si cu categoriile.
Product laptop = app.addProduct("Laptop Dell", "Laptop Dell cu procesor i5", 2000, category1);
Product laptopClone = (Product) laptop.clone();
```

# **Builder**

Builder este un model de design creațional 
care vă permite să construiți obiecte complexe pas cu pas.
Modelul vă permite să produceți diferite tipuri și
reprezentări ale unui obiect folosind același cod de construcție.
```
public class Product {
    private String name;
    private String description;
    private double price;
    private String category;

    private Product(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.category = builder.category;
    }

    // Getters

    public static class Builder {
        private String name;
        private String description;
        private double price;
        private String category;

        public Builder(String name) {
            this.name = name;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}

```
Cum lucreaza ?

Avem o clasă internă Builder care ne permite să construim obiecte Product pas cu pas.
Astfel, putem seta valorile pentru câmpurile name, description, price și category în orice ordine dorim, 
folosind metodele corespunzătoare din Builder. 


```
Product product = new Product.Builder("Iphone").description("15")
        .price(2000)
        .category("Electronice")
        .build();
```
Pentru  a crea obiectul final, apelăm metoda build() care returnează un obiect product construit cu valorile setate.

