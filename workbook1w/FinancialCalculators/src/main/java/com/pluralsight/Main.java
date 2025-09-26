package com.pluralsight;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        displayMessage();


        scanner.close();
    }
    public static void displayMessage(){
        System.out.println("Hello Welcome to pluralsight financial calculator");
        System.out.println("Please enter which calculator you would like to use: ");
        System.out.println("1: Mortgage calculator");
        System.out.println("2: Compound Interest calculator\n");
        int choice = scanner.nextInt();
        if(choice==1){
            mortgageCalculator(scanner);
        } else if (choice==2) {
            compoundInterestCalculator(scanner);
        }else{
            System.out.println("Invalid input!");
        }
    }
    public static void mortgageCalculator(Scanner scanner){
        System.out.println("Mortgage calculator\nplease input the principal amount");
        double principal = scanner.nextDouble();
        System.out.println("How much is the interest rate?");
        double interestRate = scanner.nextDouble()/100;
        System.out.println("How long is the loan duration");
        int loanLength = scanner.nextInt()*12;
        double monthlyRate = interestRate/12;
        double monthlyPayment = Math.round(principal*(monthlyRate*Math.pow(1+monthlyRate,loanLength)/(Math.pow(1+monthlyRate,loanLength)-1)));
        double totalInterest = (monthlyPayment*loanLength)-principal;
        System.out.println("For $"+principal+" principal amount with "+interestRate*100+"% interest rate for "+loanLength/12+" years the monthly payment would be: $"+monthlyPayment);
        System.out.println("The total interest would be $"+totalInterest);
    }
    public static void compoundInterestCalculator(Scanner scanner){
        System.out.println("How much did you deposited");
        double depositAmount = scanner.nextDouble();
        System.out.println("How much is the interest ");
        double interestRate = scanner.nextDouble()/100;
        System.out.println("for how many years will be deposited");
        int time = scanner.nextInt();
        double futureValue = depositAmount*Math.pow(1+(interestRate/365),(365*time));
        double interestEarned = futureValue-depositAmount;
        System.out.println("Deposit Amount: $" + depositAmount);
        System.out.println("Annual Interest Rate: " + (interestRate * 100) + "%");
        System.out.println("Time Deposited: " + time + " years");
        System.out.printf("Future Value: $%.2f\n", futureValue);
        System.out.printf("Interest Earned: $%.2f\n", interestEarned);

    }

}