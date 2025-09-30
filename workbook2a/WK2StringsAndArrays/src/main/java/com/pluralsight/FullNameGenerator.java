package com.pluralsight;

import java.util.Scanner;

public class FullNameGenerator{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Optional: Middle Name: ");
        String middleName = scanner.nextLine();
        System.out.println("Last Name");
        String lastName = scanner.nextLine();
        System.out.println("Optional: suffix");
        String suffix = scanner.nextLine();
        String displayMiddleName = middleName.isEmpty()?" ":middleName;
        String output=suffix+" "+firstName+" "+displayMiddleName+lastName;
        System.out.println(output.trim());
        scanner.close();
    }
}