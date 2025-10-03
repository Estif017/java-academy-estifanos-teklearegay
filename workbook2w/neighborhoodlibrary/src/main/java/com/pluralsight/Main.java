package com.pluralsight;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[] books = {"Treasure Island", "The Hobbit", "Life of Pi", "Atomic Habits", "The 7 Habits of Highly Effective People", "The Power of Now", "Pride and Prejudice", "1984", "To Kill a Mockingbird", "Harry Potter and the Sorcerer’s Stone", "Dune", "Ender’s Game", "Mindset", "Deep Work", "Meditations", "Man’s Search for Meaning", "The Catcher in the Rye", "Brave New World", "The Alchemist", "Sapiens"};
        String[] isbn = {"9780000000001", "9780000000002", "9780000000003", "9780000000004", "9780000000005", "9780000000006", "9780000000007", "9780000000008", "9780000000009", "9780000000010", "9780000000011", "9780000000012", "9780000000013", "9780000000014", "9780000000015", "9780000000016", "9780000000017", "9780000000018", "9780000000019", "9780000000020"};
        int[] id = {1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020};
        boolean[] isCheckedOut = {true, false, false, true, true, false, true, false, true, false, false, true, false, false, true, false, true, true, false, false};
        String[] checkedOutTo = {"Alice", null, null, "Bob", "Charlie", null, "Diana", null, "Eve", null, null, "Frank", null, null, "Grace", null, "Hank", "Ivy", null, null};
        Book book = new Book();
        int input;
        do {
            screen();
            System.out.print("Choose an option: ");
            input = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (input) {
                case 1:
                    System.out.println("📚 Showing Available Books...");
                    // TODO: call your library.showAvailableBooks();
                    book.showAvailableBooks(books,isCheckedOut,id,isbn,checkedOutTo);
                    break;
                case 2:
                    System.out.println("📕 Showing Checked Out Books...");
                    // TODO: call your library.listCheckedOutBooks();
                    book.listCheckedOutBooks(books,isCheckedOut,id,isbn,checkedOutTo);
                    break;
                case 0:
                    System.out.println("👋 Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        } while (input != 0);
    }

    public static void screen(){
        System.out.println("Wellcome to Neighborhood Library");
        System.out.println("1. Show Available Books\n" +
                "2. Show Checked Out Books\n" +
                "0. Exit - closes out of the application");
    }
}