package com.pluralsight;

import java.util.Locale;
import java.util.Scanner;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;
    Scanner scanner = new Scanner(System.in);


    public Book(){

    }
    public Book(int id, String isbn, String title, boolean isCheckedOut) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
    }

    public int getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean getIsCheckedOut() { return isCheckedOut; }
    public String getCheckedOutTo() { return checkedOutTo; }

    public void checkedOut(String name) {
        this.checkedOutTo = name;
        this.isCheckedOut = true;
    }

    public void checkIn() {
        this.isCheckedOut = false;
        this.checkedOutTo = null;
    }

    public void showAvailableBooks(String books[], boolean[] isCheckedOut,int[] id, String[] isbn,String[] checkedOutTo){
        System.out.println("📚 Available Books:");
        for (int i = 0; i < books.length; i++) {
            if (!isCheckedOut[i]) {
                System.out.println(i + ". " + books[i] + " | ID: " + id[i] + " | ISBN: " + isbn[i]);
            }
        }

        System.out.println("\nWould you like to check out a book? (Yes/No)");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("yes")) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            int index = -1;
            while (index == -1) {
                System.out.print("Enter the ID of the book you want to check out: ");
                int bookId = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline

                for (int i = 0; i < id.length; i++) {
                    if (bookId == id[i]) {
                        if (!isCheckedOut[i]) {
                            index = i;
                            isCheckedOut[i] = true;
                            checkedOutTo[i] = name;
                            System.out.println("✅ Congrats " + name + ", you successfully checked out \"" + books[index] + "\"");
                        } else {
                            System.out.println("❌ Sorry, this book is already checked out.");
                        }
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("❌ ID not found. Please try again.");
                }
            }
        }
    }

    public void listCheckedOutBooks(String books[], boolean[] isCheckedOut,int[] id, String[] isbn, String[] checkedOutTo) {
        System.out.println("📕 Checked Out Books:");
        for (int i = 0; i < books.length; i++) {
            if (isCheckedOut[i]) {
                System.out.println(i + ". " + books[i] + " | ID: " + id[i] + " | ISBN: " + isbn[i] + " | Checked out to: " + checkedOutTo[i]);
            }
        }

        System.out.println("\nWould you like to check in a book? (C to check in / X to go back)");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("c")) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            int index = -1;
            while (index == -1) {
                System.out.print("Enter the ID of the book you want to check in: ");
                int bookId = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < id.length; i++) {
                    if (bookId == id[i]) {
                        if (isCheckedOut[i] && checkedOutTo[i].equals(name)) {
                            index = i;
                            isCheckedOut[i] = false;
                            checkedOutTo[i] = null;
                            System.out.println("✅ " + name + ", you successfully checked in \"" + books[index] + "\"");
                        } else if (!isCheckedOut[i]) {
                            System.out.println("❌ This book is not checked out.");
                        } else {
                            System.out.println("❌ This book was checked out to someone else.");
                        }
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("❌ ID not found. Please try again.");
                }
            }
        }
    }
}
