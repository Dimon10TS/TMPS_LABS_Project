package com.example.laborator_1_Lab1.App;

import com.example.laborator_1_Lab1.Alte.CategoryRepository;
import com.example.laborator_1_Lab1.Alte.ConsoleUserInput;
import com.example.laborator_1_Lab1.Services.CategoryService;
import com.example.laborator_1_Lab1.Services.ProductService;
import com.example.laborator_1_Lab1.interfaces.ICategoryRepository;
import com.example.laborator_1_Lab1.interfaces.ICategoryService;
import com.example.laborator_1_Lab1.interfaces.IProductService;

import com.example.laborator_1_Lab1.interfaces.IUserInput;


public class App {
    private static ICategoryService categoryService;
    private static IProductService productService;
    private static IUserInput userInput;

    public static void main(String[] args) {
        ICategoryRepository categoryRepository = new CategoryRepository();
        categoryService = new CategoryService(categoryRepository);
        productService = new ProductService(categoryRepository);
        userInput = new ConsoleUserInput();

        int choice = 0;
        do {
            System.out.println("1. List categories");
            System.out.println("2. Show category details");
            System.out.println("3. Create new category");
            System.out.println("4. Delete category");
            System.out.println("5. Modify category title");
            System.out.println("6. Create new product");
            System.out.println("7. List products in category");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = userInput.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    listCategories();
                    break;
                case 2:
                    showCategoryDetails();
                    break;
                case 3:
                    createCategory();
                    break;
                case 4:
                    deleteCategory();
                    break;
                case 5:
                    modifyCategoryTitle();
                    break;
                case 6:
                    createProduct();
                    break;
                case 7:
                    listProductsInCategory();
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println();
        } while (choice != 8);
    }

    private static void listCategories() {
        System.out.println("Categories:");
        for (Category category : categoryService.getCategories()) {
            System.out.println(category.getTitle());
        }
    }

    private static void showCategoryDetails() {
        System.out.print("Enter category title: ");
        String title = userInput.nextString();
        Category category = categoryService.findCategory(title);
        if (category == null) {
            System.out.println("Category not found.");
            return;
        }
        System.out.println("Category details:");
        System.out.println("Title: " + category.getTitle());
        System.out.println("Products:");
        for (Product product : category.getProducts()) {
            System.out.println(product.getName() + " - " + product.getDescription() + " - " + product.getPrice());
        }
    }

    private static void createCategory() {
        System.out.print("Enter category title: ");
        String title = userInput.nextString();
        categoryService.createCategory(title);
        System.out.println("Category created successfully.");
    }


    // App.java (continuation)
    private static void deleteCategory() {
        System.out.print("Enter category title: ");
        String title = userInput.nextString();
        Category category = categoryService.findCategory(title);
        if (category == null) {
            System.out.println("Category not found.");
            return;
        }
        categoryService.deleteCategory(title);
        System.out.println("Category deleted successfully.");
    }

    private static void modifyCategoryTitle() {
        System.out.print("Enter category title: ");
        String oldTitle = userInput.nextString();
        Category category = categoryService.findCategory(oldTitle);
        if (category == null) {
            System.out.println("Category not found.");
            return;
        }
        System.out.print("Enter new title: ");
        String newTitle = userInput.nextString();
        categoryService.modifyCategoryTitle(oldTitle, newTitle);
        System.out.println("Category title modified successfully.");
    }

    private static void createProduct() {
        System.out.print("Enter category title: ");
        String categoryTitle = userInput.nextString();
        Category category = CategoryService.findCategory(categoryTitle);
        if (category == null) {
            System.out.println("Category not found.");
            return;
        }
        System.out.print("Enter product name: ");
        String productName = userInput.nextString();
        System.out.print("Enter product description: ");
        String productDescription = userInput.nextString();
        System.out.print("Enter product price: ");
        double productPrice = userInput.nextDouble();
        productService.createProduct(categoryTitle, productName, productDescription, productPrice);
        System.out.println("Product created successfully.");
    }

    private static void listProductsInCategory() {
        System.out.print("Enter category title: ");
        String categoryTitle = userInput.nextString();
        Category category = CategoryService.findCategory(categoryTitle);
        if (category == null) {
            System.out.println("Category not found.");
            return;
        }
        System.out.println("Products in category \"" + category.getTitle() + "\":");
        for (Product product : productService.listProductsInCategory(categoryTitle)) {
            System.out.println(product.getName() + " - " + product.getDescription() + " - " + product.getPrice());
        }
    }
}