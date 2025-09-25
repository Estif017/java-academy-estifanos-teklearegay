package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        double gross =calculator(scanner);
        System.out.println("And your annual gross pay is "+gross);
    }

    public static double calculator(Scanner scanner){
        System.out.println("please enter how many hours you've work: ");
        double hours = scanner.nextDouble();
        System.out.println("Thank you! And what is your hourly rate? ");
        double pay_rate = scanner.nextDouble();
        double gross_pay = (hours*pay_rate)*52;
        return gross_pay;
    }
}