package com.helperMethods;

import java.util.Scanner;

public class HelperMethod {
    static Scanner scanner = new Scanner(System.in);
    public static int safeIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("⚠️ Please enter a valid number.");
            scanner.nextLine();
            System.out.print("Try again: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        return value;
    }

    public static double safeDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("⚠️ Please enter a valid decimal number.");
            scanner.nextLine();
            System.out.print("Try again: ");
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    public static String capitalize(String input) {
        if (input == null || input.isBlank()) return "";
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
