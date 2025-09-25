package com.pluralsight;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi Welcome to Java sandwich shop");
        System.out.println("Please choose size");
        System.out.println("1: Regular: base price $5.45");
        System.out.println("2: Large: base price $8.95");
        System.out.println("Please type 1 or 2:");

        int size = scanner.nextInt();
        double price = size == 1 ? 5.45 : 8.95;

        double loadedPrice = size == 1 ? 1.00 : 1.75;
        System.out.println("Would you like the sandwich to be loaded for "+ loadedPrice+"? (Enter true or false)");
        boolean loaded = scanner.nextBoolean();
        if(loaded){
            price = price + loadedPrice;
        }

        System.out.println("Please enter your age to see if you are eligable for promotion: ");
        int age = scanner.nextInt();
        double discount = 0;
        if(age<=17){
            discount = price * 0.1;
        }else if(age>=65){
            discount = price*0.2;
        }else{
            System.out.println("You are not eligable for discount");
        }
        double totalPrice = Math.round(price - discount);
        System.out.println("Your total will be "+ totalPrice);
        scanner.close();
    }
}