package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        int choice;
        do {
            // Display menu
            menu();

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("We carry the following inventory: ");
                    for (Product p : inventory) {
                        System.out.printf("id: %d %s - Price: $%.2f\n",p.getId(),p.getName(),p.getPrice());
                    }
                    break;
                case 2:
                    System.out.println("Enter product ID:");
                    int id = scanner.nextInt();
                    System.out.println("Looking up product with ID: " + id);
                    lookingUpProduct(inventory,id);
                    // call your method to lookup product by id here
                    break;
                case 3:
                    System.out.println("Enter minimum price:");
                    double minPrice = scanner.nextDouble();
                    System.out.println("Enter maximum price:");
                    double maxPrice = scanner.nextDouble();
                    System.out.println("Finding products between " + minPrice + " and " + maxPrice);
                    // call your method to find products by price range here
                    lookingUpProductWithPriceRange(inventory,minPrice,maxPrice);
                    break;
                case 4:
                    System.out.println("Adding a new product...");
                    // call your method to add a new product here
                    inventory.add(addNewProduct(inventory));

                    break;
                case 5:
                    System.out.println("Quitting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // blank line for readability

        } while (choice != 5);

        scanner.close();

    }
    public static ArrayList<Product> getInventory(){
        ArrayList<Product> inventory = new ArrayList<Product>();
        String filePath = "src/main/resources/inventory.csv";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;
            bufferedReader.readLine();// skipping first line
            while((line= bufferedReader.readLine())!=null){
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                float price = Float.parseFloat(parts[2]);
                inventory.add(new Product(id,name,price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    public static void lookingUpProduct(ArrayList<Product> inventory, int id){
        for(Product product: inventory){
            if(product.getId()==id){
                System.out.printf("id: %d %s - Price: $%.2f\n",product.getId(),product.getName(),product.getPrice());
            }
        }
    }

    public static void lookingUpProductWithPriceRange(ArrayList<Product> inventory, double min, double max){
        for(Product product: inventory){
            if(product.getPrice()>min && product.getPrice()<=max){
                System.out.printf("id: %d %s - Price: $%.2f\n",product.getId(),product.getName(),product.getPrice());
            }
        }
    }

    public static Product addNewProduct(ArrayList<Product> products){
        System.out.println("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the price: ");
        float price = scanner.nextFloat();
        int id = products.size()+1;
        Product product = new Product(id,name,price);
        writeNewProductToinventoryTxt(id,name,price);
        return product;
    }

    public static void writeNewProductToinventoryTxt(int id, String productName, float price){
        try{
            String filePath = "src/main/resources/inventory.csv";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));
            writer.write(String.format("%d,%s,%.2f%n", id, productName, price));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void menu(){
        System.out.println("1- List all products");
        System.out.println("2- Lookup a product by its id");
        System.out.println("3- Find all products within a price range");
        System.out.println("4- Add a new product");
        System.out.println("5- Quit the application");
        System.out.print("Enter your choice: ");
    }

}