# TMPSlaburi

Mai intîi voi spune ce face aplicația dată:
System.out.println("1. List categories");
System.out.println("2. Show category details");
System.out.println("3. Create new category");
System.out.println("4. Delete category");
System.out.println("5. Modify category title");
System.out.println("6. Create new product");
System.out.println("7. List products in category");

___

# Single Responsibility Principle


Fiecare clasă și interfață din proiect are o singură responsabilitate:

Product și Category: modele pentru stocarea datelor despre produse și categorii.
ICategoryRepository și CategoryRepository: interfață și implementare pentru gestionarea datelor despre categorii (creare, ștergere, actualizare și căutare).
ICategoryService și CategoryService: interfață și implementare pentru gestionarea logicii de afaceri și a operațiilor legate de categorii.

___
# Open/Closed Principle


Proiectul este deschis pentru extindere și închis pentru modificare, deoarece funcționalitatea poate fi adăugată sau modificată prin crearea de noi implementări
ale interfețelor, fără a modifica codul existent.
De exemplu, putem adăuga o nouă implementare a ICategoryRepository care stochează datele într-o bază de date, fără a modifica restul codului.
Functionalul dat se va extinde in laboratoarele urmatoare.
___


# Liskov Substitution Principle

Interfețele ICategoryRepository și ICategoryService permit substituția implementărilor concrete în mod transparent, fără a afecta comportamentul aplicației.
___

# Interface Segregation Principle


Interfețele ICategoryRepository și ICategoryService sunt mici și concentrate pe o singură responsabilitate,
ceea ce înseamnă că orice clasă care le implementează nu va trebui să implementeze metode inutile sau nepotrivite.
Acest lucru face ca interfețele să fie ușor de implementat și de înțeles.

___
# Dependency Inversion Principle


Aplicația depinde de abstracțiuni, nu de implementări concrete. Acest lucru este evident în modul în care CategoryService depinde de interfața ICategoryRepository în loc de o implementare concretă, precum CategoryRepository.
Aceasta permite flexibilitate în alegerea și schimbarea surselor de date pentru categorii, fără a afecta logica de afaceri a aplicației.
___
Prin urmare, pot spune ca toate principiile solid au fost folosite in mini aplicatia data.
