package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductQueries {
    public static void displayAllProducts(BasicDataSource dataSource){
        String sql = """
                SELECT ProductID, ProductName, UnitPrice, UnitsInStock
                FROM products
                ORDER BY ProductID
                """;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
        ) {

            System.out.printf("%-5s | %-35s | %10s | %10s%n",
                    "ID", "Name", "Price", "In Stock");
            System.out.println("---------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-5d | %-35s | %10.2f | %10d%n",
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getDouble("UnitPrice"),
                        rs.getInt("UnitsInStock"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayAllCategoriesAndProducts(BasicDataSource dataSource) {
        Scanner scanner = new Scanner(System.in);
        String catSql = """
                SELECT CategoryID, CategoryName
                FROM categories
                ORDER BY CategoryID
                """;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(catSql);
                ResultSet rs = stmt.executeQuery()
        ) {
            System.out.println("\nCategories:");
            System.out.printf("%-5s | %-30s%n", "ID", "Name");
            System.out.println("------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("CategoryID");
                String name = rs.getString("CategoryName");
                System.out.printf("%-5d | %-30s%n", id, name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.print("\nEnter a Category ID to view its products: ");
        String input = scanner.nextLine();
        int categoryId;

        try{
            categoryId = Integer.parseInt(input);
        }catch (NumberFormatException e){
            System.out.println("Invalid Number.");
            return;
        }

        String prodSql = """
                SELECT ProductID, ProductName, UnitPrice, UnitsInStock
                FROM products
                WHERE CategoryID = ?
                ORDER BY ProductID
                """;

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement prodStmt = connection.prepareStatement(prodSql);
        )
        {
            prodStmt.setInt(1,categoryId);
            try( ResultSet rs = prodStmt.executeQuery()){
                if (!rs.next()) {
                    System.out.println("No products found for that category.");
                    return;
                }

                System.out.println("\nProducts in category " + categoryId + ":");
                System.out.printf("%-5s | %-35s | %10s | %10s%n",
                        "ID", "Name", "Price", "In Stock");
                System.out.println("---------------------------------------------------------------");

                do {
                    int id = rs.getInt("ProductID");
                    String name = rs.getString("ProductName");
                    double price = rs.getDouble("UnitPrice");
                    int stock = rs.getInt("UnitsInStock");

                    System.out.printf("%-5d | %-35s | %10.2f | %10d%n",
                            id, name, price, stock);
                } while (rs.next());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
