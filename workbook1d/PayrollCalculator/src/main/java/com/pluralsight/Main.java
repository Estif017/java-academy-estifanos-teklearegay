package com.pluralsight;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello "+name+" please enter how many hours you've work: ");
        float hours = scanner.nextFloat();
        System.out.println("Thank you! And what is your hourly rate? ");
        float pay_rate = scanner.nextFloat();
        System.out.println("Thank you "+ name+ " you worked "+hours+" for $"+pay_rate+" per hour");
        float gross_pay = (hours*pay_rate)*52;
        System.out.println("And your annual gross pay is "+gross_pay);
    }

}