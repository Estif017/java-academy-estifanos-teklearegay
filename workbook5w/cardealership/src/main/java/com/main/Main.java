package com.main;

import com.contract.ContractUserInterface;
import com.dealership.UserInterface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Dealership System!");
        System.out.print("Are you an Admin or a Guest? (type 'admin' or 'guest'): ");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("admin")){
            adminMode();
        }else{
            UserInterface ui = new UserInterface();
            ui.Display();
        }
    }

    private static boolean authenticateAdmin(String username, String password){
        boolean isMatch = false;
        try(BufferedReader br = new BufferedReader(new FileReader("authontication.csv"))){
            String line;
            while ((line = br.readLine())!=null){
                String[] parts = line.split("\\|");
                if(parts.length==2){
                    String fileUsername = parts[0].trim();
                    String filePassword = parts[1].trim();
                    if (fileUsername.equals(username) && filePassword.equals(password)){
                        isMatch = true;
                        return isMatch;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return isMatch;
    }

    public static void adminMode(){
        System.out.print("Enter user name: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if(authenticateAdmin(username,password)){
            System.out.println("Login successful! Welcome, " + username + ".");
            ContractUserInterface ui = new ContractUserInterface();
            ui.display();
        }else{
            System.out.println("Invalid username or password. Access denied.");
            System.out.println("Going back to Guest Mode...");
            UserInterface ui = new UserInterface();
            ui.Display();
        }
    }
}
