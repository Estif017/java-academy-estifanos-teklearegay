package com.pluralsight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String LOG_FILE = "logs.txt";
    public static void main(String[] args) {
        logAction("Launching the application");

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("=== Welcome to SearchEngineLogger ===");

        while (true) {
            System.out.print("Enter a search term (or type 'exit' to quit): ");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                logAction("Exiting the application");
                System.out.println("Goodbye!");
                break;
            } else if (!input.isEmpty()) {
                logAction("Searching for term: \"" + input + "\"");
                System.out.println("You searched for: " + input);
            } else {
                System.out.println("Please enter a valid search term.");
            }
        }

        scanner.close();
    }

    private static void logAction(String action){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeStamp = LocalDateTime.now().format(formatter);
        String logEntry = timeStamp + " - " + action;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE,true))){
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}