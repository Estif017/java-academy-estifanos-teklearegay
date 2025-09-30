package com.pluralsight;

// A simple Java project in ONE file
// Demonstrates Strings, Loops, and Arrays
// Author: Remsey's Learning Project

import java.util.Scanner;

public class Wk2StringAndArrays {

    public static void main(String[] args) {

        // ============================
        // 1. STRINGS
        // ============================
        System.out.println("=== STRINGS ===");

        String name = "Remsey";
        System.out.println("Hello, " + name); // Concatenation

        // String methods
        System.out.println("Length of name: " + name.length());
        System.out.println("Uppercase: " + name.toUpperCase());
        System.out.println("LowercASE: " + name.toLowerCase());
        System.out.println("First letter: " + name.charAt(0));   //R
        System.out.println("Does it contain 'sey'? " + name.contains("sey")); //true or false

        String pincode = "1234";
        String movieTitle = "spiderman 3 is the best movie ever";

        int amountOfCharacters = pincode.length();
        if(amountOfCharacters >= 4)
        {
            System.out.println("To many characters for your pincode");
        }

        boolean isASpiderManMovie = movieTitle.contains("Spiderman");
        if(isASpiderManMovie) {
            System.out.println("Go watch it");
        }


        movieTitle.equals("Spiderman");



        // ============================
        // 2. LOOPS
        // ============================
        System.out.println("\n=== LOOPS ===");

        // For loop
        System.out.println("Counting from 1 to 5:");
        for (int counter = 1; counter <= 5; counter++) {
            System.out.println("Number: " + counter);
        }

        // For loop;
        for (int i = 0; i < 3; i++) {
            System.out.println("You guys are cool!");
        }

        // For loop;


        for (int i = 0; i < 3; i++) {
            System.out.println("Move forward!");
        }


        // While loop
        System.out.println("\nWhile loop example:");
        int counter = 3;
        while (counter > 0) {
            System.out.println("Counter is: " + counter);
            counter--; // decrease by 1
        }


        // While loop
        System.out.println("\nPassword is incorrect:");
        Scanner read = new Scanner(System.in);

        boolean passwordIncorrect = true;
        String password = "1234";
        String enterPassword = "";

        while (passwordIncorrect) {
            System.out.println("What is the password?");
            enterPassword = read.nextLine();
            if(!enterPassword.equals(password)) {
                System.out.println("Incorrect");
            }else{
                passwordIncorrect = false;

            }

        }

        // Do-while loop
        System.out.println("\nDo-while loop example:");
        int x = 0;
        do {
            System.out.println("x is: " + x);
            x++;
        } while (x < 3);

        // ============================
        // 3. ARRAYS
        // ============================
        System.out.println("\n=== ARRAYS ===");

        // Declare and initialize
        int[] numbers = {10, 20, 30, 40, 50};

        // Access elements
        System.out.println("First element: " + numbers[0]);
        System.out.println("Last element: " + numbers[numbers.length - 1]);

        // Loop through array
        System.out.println("\nAll elements in array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }

        // Enhanced for loop (for-each)
        System.out.println("\nUsing for-each loop:");
        for (int num : numbers) {
            System.out.println("Value: " + num);
        }

        // ============================
        // 4. COMBINING STRINGS + ARRAYS + LOOPS
        // ============================
        System.out.println("\n=== COMBINED EXAMPLE ===");

        String[] fruits = {"Apple", "Banana", "Cherry"};

        // Print each fruit in uppercase
        for (String fruit : fruits) {
            System.out.println(fruit.toUpperCase());
        }

        // Count total characters in all fruits
        int totalChars = 0;
        for (String fruit : fruits) {
            totalChars += fruit.length();
        }
        System.out.println("Total characters in all fruit names: " + totalChars);

        // Done!
        System.out.println("\n== END OF PROJECT ===");

        // A simple Java project in ONE file
        // Theme: Netflix & Movies
        // Demonstrates Strings, Loops, and Arrays
        // Author: Remsey's Learning Project


        // ============================
        // 1. STRINGS
        // ============================
        System.out.println("=== STRINGS (Movie Titles) ===");

        String movie = "Inception";
        System.out.println("Now streaming: " + movie); // Concatenation

        // String methods
        System.out.println("Title length: " + movie.length());
        System.out.println("Uppercase: " + movie.toUpperCase());
        System.out.println("First letter: " + movie.charAt(0));
        System.out.println("Does it contain 'cep'? " + movie.contains("cep"));

        // ============================
        // 2. LOOPS
        // ============================
        System.out.println("\n=== LOOPS (Episode Counter) ===");

        // For loop
        System.out.println("Binge-watching 5 episodes:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Episode " + i + " is playing...");
        }

        // While loop
        System.out.println("\nWhile loop example (countdown to next season):");
        int days = 3;
        while (days > 0) {
            System.out.println(days + " days left until new season drops!");
            days--;
        }

        // Do-while loop
        System.out.println("\nDo-while loop example (keep watching until tired):");
        int episodesWatched = 0;
        do {
            System.out.println("Watched episode " + (episodesWatched + 1));
            episodesWatched++;
        } while (episodesWatched < 3);

        // ============================
        // 3. ARRAYS
        // ============================
        System.out.println("\n=== ARRAYS (Movie Ratings) ===");

        // Declare and initialize
        int[] ratings = {5, 4, 3, 5, 4}; // out of 5 stars

        // Access elements
        System.out.println("First rating: " + ratings[0] + " stars");
        System.out.println("Last rating: " + ratings[ratings.length - 1] + " stars");

        // Loop through array
        System.out.println("\nAll ratings:");
        for (int i = 0; i < ratings.length; i++) {
            System.out.println("User " + (i + 1) + " gave: " + ratings[i] + " stars");
        }

        // Enhanced for loop (for-each)
        System.out.println("\nUsing for-each loop:");
        for (int r : ratings) {
            System.out.println("Rating: " + r + " stars");
        }

        // ============================
        // 4. COMBINING STRINGS + ARRAYS + LOOPS
        // ============================
        System.out.println("\n=== COMBINED EXAMPLE (Netflix Library) ===");

        String[] movies = {"Stranger Things", "The Witcher", "Money Heist"};

        // Print each movie in uppercase
        for (String m : movies) {
            System.out.println("Available: " + m.toUpperCase());
        }

        // Count total characters in all movie titles
        int totalAmountOfChars = 0;
        for (String m : movies) {
            totalAmountOfChars += m.length();
        }
        System.out.println("Total characters in all movie titles: " + totalAmountOfChars);

        // Done!
        System.out.println("\n=== END OF NETFLIX PROJECT ===");
    }
}

