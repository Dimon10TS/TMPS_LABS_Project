# Behavioural Design Patterns
___
În raportul dat  sunt utilizate 4 tipuri de design patterns comportamentale:

• Observator (Observer)

• Strategie (Strategy)

• Iterator

• State

---



Design pattern-ul Observator este utilizat pentru a notifica clasa App despre modificările aduse în lista de categorii a clasei CategoryService.
Clasa CategoryService se comportă ca subiect, iar clasa App se comportă ca și observator.
Astfel, atunci când lista de categorii este actualizată,
metoda update din clasa App este apelată.
---

Pentru a implementa Observer Pattern, am defenit o interfață CategoryObserver cu o metodă update(List\<Category\> categories).


```
package com.example.TMPS\_PROIECT.interfaces;

import com.example.TMPS\_PROIECT.App.Category;

import java.util.List;

public interface CategoryObserver {
void update(List\<Category\> categories);
}
```
Această metodă va fi apelată de fiecare dată când se adaugă sau se modifică o categorie. Clasele care implementează interfața CategoryObserver vor fi notificate de fiecare dată când se face o astfel de modificare.

După aceasta v-om modifica clasa CategoryService ca să mențină o listă de observatori, să le notifice pe acestea la fiecare modificare și să le permită să se adauge sau să se șteargă din lista de observatori. În cele din urmă, vom modifica clasa App astfel încât să implementeze interfața CategoryObserver, astfel încât să fie notificată de fiecare dată când se adaugă sau se modifică o categorie.

Prin cele spuse de mai sus vreau să le arăt în exemplul de mai jos
```
public CategoryService() {
categories = new ArrayList\<\>();
observers = new ArrayList\<\>();
}
```

```
public void modifyCategoryTitle(Category category, String newTitle) {
category.setTitle(newTitle);
notifyObservers();
}
```
```
public void addCategory(Category category) {
categories.add(category);
notifyObservers();
}
```
```
public void removeCategory(Category category) {
categories.remove(category);
notifyObservers();
for (Product product : category.getProducts()) {
product.setCategory(null);
}
}
```

# **_Strategy Design Patern._**

---

Acest pattern permite schimbarea algoritmului fără a afecta clientul care folosește acel algoritm.
Design pattern-ul Strategie este utilizat pentru a permite sortarea si cautarea produselor în
funcție de diferite criterii.
Clasa ProductService utilizează o interfață SortStrategy
pentru a sorta produsele în funcție de diferite criterii.
Astfel, se poate alege strategia de sortare dorită,
iar sortarea se face în funcție de aceasta.
```
package com.example.TMPS\_PROIECT.interfaces;

import com.example.TMPS\_PROIECT.App.Product;

import java.util.List;

public interface SortStrategy {
List\<Product\> sort(List\<Product\> products);
}
```
```
// Afisăm lista de produse din categoria "Electronice", sortată după nume
System.out.println("Lista de produse din categoria \"Electronice\", sortata după nume:");
List\<Product\> productsByName = app.getProductsSortedByName(category1);
for (Product product : productsByName) {
System.out.println(product);
}
System.out.println();
System.out.println("---------------Sortare dupa Nume ----------------------");

// Afisăm lista de produse din categoria "Haine", sortată după preț

System.out.println("---------------Sortare dupa Pret ----------------------");

System._out_.println("Lista de produse din categoria \"Haine\", sortata dupa pret:");
List\<Product\> productsByPrice = app.getProductsSortedByPrice(category2);
for (Product product : productsByPrice) {
System.out.println(product);
}
```
Astfel, sortarea o putem face după nume sau categorie.

Un alt exemplu ar fi că există o interfață numită SearchStrategy care definește o metodă search() pentru a căuta produsele în funcție de un cuvânt cheie și o listă de produse. Avem două clase care implementează această interfață pentru a căuta produse după nume sau descriere. Avem, de asemenea, clasa ProductSearcher care primește o strategie de căutare și căuta produsele utilizând acea strategie.
```
package com.example.TMPS\_PROIECT.interfaces;

import com.example.TMPS\_PROIECT.App.Product;

import java.util.List;

public interface SearchStrategy {
public List\<Product\> search(String keyword, List\<Product\> productList);
}
```




```
// cautarea produselor dupa nume
SearchStrategy nameSearchStrategy = new NameSearchStrategy();
ProductSearcher nameSearcher = new ProductSearcher(nameSearchStrategy);
List\<Product\> foundProductsByName = nameSearcher.searchProducts("Samsung", products);

// cautarea produselor dupa descriere
SearchStrategy descriptionSearchStrategy = new DescriptionSearchStrategy();
ProductSearcher descriptionSearcher = new ProductSearcher(descriptionSearchStrategy);
List\<Product\> foundProductsByDescription = descriptionSearcher.searchProducts("procesor", products);
```

# **Iterator**
Iteratorul este un model de design comportamental care vă permite să traversați elemente ale unei colecții fără a 
expune reprezentarea de bază (listă, stivă, arbore etc.).

am defenit o interfață RoleIterator cu metode pentru iterarea prin lista de roluri.

```
public interface RoleIterator {
    boolean hasNext();
    Role next();
}

```

```
public class RoleList implements RoleIterator {
    private List<Role> roles;
    private int position;

    public RoleList(List<Role> roles) {
        this.roles = roles;
        this.position = 0;
    }

    public boolean hasNext() {
        return position < roles.size();
    }

    public Role next() {
        Role role = roles.get(position);
        position++;
        return role;
    }
}

```

# **State**

Starea este un model de design comportamental 
care permite unui obiect să-și modifice comportamentul
atunci când starea sa internă se schimbă.

Am definit o interfață UserRoleState care conține metode
pentru gestionarea stării unui rol.
```
public interface UserRoleState {
    void performAction();
}

```
Am creiat clase pentru diferitele stări ale unui rol 
(activ si inactiv)
și am implementat metodele specifice pentru fiecare stare.
```
public class ActiveState implements UserRoleState {
    public void performAction() {
        System.out.println("Performing actions for active role");
    }
}

public class InactiveState implements UserRoleState {
    public void performAction() {
        System.out.println("Performing actions for inactive role");
    }
}

```
In acest cod se va itera prin lista de roluri și va apela metoda performAction() specifică pentru fiecare rol în funcție de starea sa.
```
 List<Role> roles = new ArrayList<>();
        roles.add(new Role("Admin"));
        roles.add(new Role("User"));

        RoleList roleList = new RoleList(roles);
        while (roleList.hasNext()) {
            Role role = roleList.next();
            role.performAction();
        }
    }
```