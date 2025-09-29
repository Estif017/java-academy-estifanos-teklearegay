package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Pluralsight Financial Calculator");
        boolean running = true;
        while(running){
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice){
                case 1 -> mortgageCalculator(scanner);
                case 2 -> compoundInterestCalculator(scanner);
                case 3 -> annuityCalculator(scanner);
                case 0 ->{
                    System.out.println("Exiting... Thank you!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
    public static void displayMenu(){
        System.out.println("\nPlease choose a calculator:");
        System.out.println("1: Mortgage Calculator");
        System.out.println("2: Compound Interest Calculator");
        System.out.println("3: Annuity Calculator");
        System.out.println("0: Exit");
        System.out.print("Enter your choice: ");

    }
    public static void mortgageCalculator(Scanner scanner){
        System.out.println("\n--- Mortgage Calculator ---");

        System.out.print("Enter the principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (%): ");
        double interestRate = scanner.nextDouble()/100;

        System.out.print("Enter the loan duration (years): ");
        int loanLength = scanner.nextInt()*12;
        double monthlyRate = interestRate/12;

        double monthlyPayment = Math.round(principal*(monthlyRate*Math.pow(1+monthlyRate,loanLength)/(Math.pow(1+monthlyRate,loanLength)-1)));
        double totalInterest = (monthlyPayment*loanLength)-principal;

        System.out.println("For $"+principal+" principal amount with "+interestRate*100+"% interest rate for "+loanLength/12+" years the monthly payment would be: $"+monthlyPayment);
        System.out.println("The total interest would be $"+totalInterest);
    }
    public static void compoundInterestCalculator(Scanner scanner){
        System.out.println("\n--- Compound Interest Calculator ---");

        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();

        System.out.print("Enter annual interest rate (%): ");
        double interestRate = scanner.nextDouble()/100;

        System.out.print("Enter time (years): ");
        int time = scanner.nextInt();

        double futureValue = depositAmount*Math.pow(1+(interestRate/365),(365*time));
        double interestEarned = futureValue-depositAmount;

        System.out.println("Deposit Amount: $" + depositAmount);
        System.out.println("Annual Interest Rate: " + (interestRate * 100) + "%");
        System.out.println("Time Deposited: " + time + " years");
        System.out.printf("Future Value: $%.2f\n", futureValue);
        System.out.printf("Interest Earned: $%.2f\n", interestEarned);

    }

    public static void annuityCalculator(Scanner scanner){
        System.out.println("\n--- Annuity Calculator ---");

        System.out.print("Enter the monthly payout: ");
        double monthlyPayout = scanner.nextDouble();

        System.out.println("Enter the expected annual interest rate (in %):");
        double expInterestRate = scanner.nextDouble();

        System.out.println("Enter the number of years for the payout:");
        int time = scanner.nextInt();

        double monthlyRate = expInterestRate/100/12;
        int totalMonths = time * 12; // n
        double presentValue = monthlyPayout * (1 - Math.pow(1 + monthlyRate, -totalMonths)) / monthlyRate;
        System.out.printf("To fund an annuity paying $%.2f per month for %d years at %.2f%% interest, you need to invest $%.2f today.\n",
                monthlyPayout, time, expInterestRate, presentValue);

    }
}


