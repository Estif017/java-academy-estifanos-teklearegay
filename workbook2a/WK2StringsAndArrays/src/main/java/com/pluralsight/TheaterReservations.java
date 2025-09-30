package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Please enter your name: ");
        String fullName = scanner.nextLine();
        String formattedName = fullName.replaceFirst(" ",", ");
        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String inputDate  = scanner.nextLine();
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(inputDate, inputFormat);
        String formattedDate = date.format(outputFormat);
        System.out.print("How many tickets would you like? ");
        int numberOfTickets = scanner.nextInt();
        System.out.println(numberOfTickets+" tickets reserved for "+formattedDate+" under "+formattedName);
    }
}