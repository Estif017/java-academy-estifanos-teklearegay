package com.pluralsight;

public class CompareNumbers {
    public static void main(String[] args) {
        boolean isEvenChecker = isEven(8);
        System.out.println(isEvenChecker);

        boolean isPostiveChecker = isPostive(7);
        System.out.println(isPostiveChecker);
    }

    public static boolean isEven(double number){
        return number % 2 == 0;
    }
    public static boolean isPostive(double number){
        return number > 0;
    }
}