package com.pluralsight;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int number1 = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int number2 = scanner.nextInt();
        System.out.println("What you wanna do next");
        System.out.println("A for add");
        System.out.println("S for substract");
        System.out.println("D for division");
        System.out.println("M for multiplication");
        scanner.nextLine();
        char operation = scanner.next().charAt(0);
        double result;
        if(operation == 'A' || operation=='a'){
            result = number1 + number2;
        }else if(operation == 'S' || operation=='s'){
            result = number1 - number2;
        }else if(operation == 'D' || operation=='d'){
            result = number1 / number2;
        }else if(operation == 'M' || operation=='m'){
            result = number1 * number2;
        } else{
            result = 0;
            System.out.println("Wrong response");
        }
        System.out.println("Preparing to do math... ");
        System.out.println("your result is "+ result);
    }
}