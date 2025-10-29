package com.helperMethods;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

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
    public static String generateRandomDate(int startYear, int endYear) {
        long startEpochDay = LocalDate.of(startYear, 1, 1).toEpochDay();
        long endEpochDay = LocalDate.of(endYear, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate.toString(); // returns as "YYYY-MM-DD"
    }
}
