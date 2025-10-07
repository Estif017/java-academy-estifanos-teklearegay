package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] quotes = {
                "The best way to predict the future is to create it.",
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                "Believe you can and you're halfway there.",
                "Don’t watch the clock; do what it does. Keep going.",
                "The harder you work for something, the greater you’ll feel when you achieve it.",
                "Dream big and dare to fail.",
                "Your time is limited, so don’t waste it living someone else’s life.",
                "It always seems impossible until it’s done.",
                "Happiness is not something ready made. It comes from your own actions.",
                "In the middle of every difficulty lies opportunity."
        };
        while (true) {
            try {
                System.out.println("Please input a number between 1 and 10 (press 0 to exit): ");
                int input = scanner.nextInt();

                if (input == 0) {
                    System.out.println("Goodbye!");
                    break;
                }
                // check range before accessing array
                if (input < 1 || input > quotes.length) {
                    System.out.println("⚠️ Invalid number! Please enter a number between 1 and 10.");
                } else {
                    System.out.println("💬 " + quotes[input - 1]);
                }

            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter a number between 1 and 10 (no letters or symbols).");
                scanner.nextLine(); // clear invalid input from the buffer
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("⚠️ That number is out of range! Please try again between 1 and 10.");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}