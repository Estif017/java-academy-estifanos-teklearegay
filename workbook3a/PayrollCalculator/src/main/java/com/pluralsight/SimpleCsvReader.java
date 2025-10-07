package com.pluralsight;

import java.io.*;       // For File, FileReader, BufferedReader, IOException
import java.net.URL;    // For loading resource as URL

public class SimpleCsvReader {
    public static void main(String[] args) throws Exception {

        // Load the CSV file from the 'resources' folder using the class loader
        URL resource = SimpleCsvReader.class.getClassLoader().getResource("data.csv");

        // If the file is not found, print a message and stop the program
        if (resource == null) {
            System.out.println("File not found!");
            return;
        }

        // Create a File object using the path from the resource URL
        File file = new File(resource.getFile());

        // Try-with-resources: Automatically closes the reader when done
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line (CSV row) to the console
            }

        } // reader is automatically closed here
    }
}