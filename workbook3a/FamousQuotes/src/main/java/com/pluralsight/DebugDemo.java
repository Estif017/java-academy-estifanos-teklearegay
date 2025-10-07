package com.pluralsight;

public class DebugDemo {
    public static void main(String[] args) {
        int number = 5;
        int result = number * 2;

        System.out.println("Double of number is: " + result); // variable error
        if (number > 0) { // logical error
            System.out.println("The number is positive.");
        }
    }
}
