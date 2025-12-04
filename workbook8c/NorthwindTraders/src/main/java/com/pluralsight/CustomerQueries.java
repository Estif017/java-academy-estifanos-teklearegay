package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerQueries {
    public static void displayAllCustomers(BasicDataSource dataSource){
        String sql = """
                SELECT ContactName, CompanyName, City, Country, Phone
                FROM customers
                ORDER BY Country, ContactName
                """;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            System.out.printf("%-30s | %-30s | %-15s | %-15s | %-20s%n",
                    "Contact", "Company", "City", "Country", "Phone");
            System.out.println("---------------------------------------------------------------------------------------------");

            while (rs.next()){
                System.out.printf("%-30s | %-30s | %-15s | %-15s | %-20s%n",
                        rs.getString("ContactName"),
                        rs.getString("CompanyName"),
                        rs.getString("City"),
                        rs.getString("Country"),
                        rs.getString("Phone"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
