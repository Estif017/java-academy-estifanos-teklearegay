package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

import static com.pluralsight.CustomerQueries.displayAllCustomers;
import static com.pluralsight.ProductQueries.displayAllCategoriesAndProducts;
import static com.pluralsight.ProductQueries.displayAllProducts;

public class NorthwindTraders {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        BasicDataSource dataSource = DatabaseConfig.getDataSource();
          ui(dataSource);

        scanner.close();
        System.out.println("Goodbye!");
    }

    public static void ui(BasicDataSource dataSource){
        boolean running = true;

        while (running){
            System.out.println("\nWhat do you want to do?");
            System.out.println(" 1) Display all products");
            System.out.println(" 2) Display all customers");
            System.out.println(" 3) Display all categories");
            System.out.println(" 0) Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice){
                case "1" -> displayAllProducts(dataSource);
                case "2" -> displayAllCustomers(dataSource);
                case "3" -> displayAllCategoriesAndProducts(dataSource);
                case "0" -> running = false;
                default -> System.out.println("❌ Invalid option");
            }
        }
    }
}
