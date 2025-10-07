package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Enter the name of a story (goldilocks, hansel_and_gretel, mary_had_a_little_lamb): ");
            String title = scanner.nextLine().trim().toLowerCase();
            String filePath = "";
            switch (title) {
                case "goldilocks":
                    filePath = "src/goldilocks.txt";
                    break;
                case "hansel_and_gretel":
                    filePath = "src/hansel_and_gretel.txt";
                    break;
                case "mary_had_a_little_lamb":
                    filePath = "src/mary_had_a_little_lamb.txt";
                    break;
                default:
                    System.out.println("❌ Story not found. Please check the spelling and try again.");
                    return; // stop execution here
            }

            try(FileReader fileReader = new FileReader(filePath)){
                System.out.println("\n📖 Opening story: " + title.replace("_", " ").toUpperCase());
                System.out.println("----------------------------------------------------");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;

                while ((line=bufferedReader.readLine())!=null){
                    System.out.println(line);
                }
                System.out.println("----------------------------------------------------");
                System.out.println("✨ The End ✨");
            }catch (IOException e){
                System.out.println("⚠️ Error reading file: " + e.getMessage());

            }
        }finally {
            scanner.close();
        }
    }
}