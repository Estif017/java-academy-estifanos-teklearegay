package com.pluralsight.finance;

import com.pluralsight.Portfolio;

public class FinanceApplication {
    public static void main(String[] args) {

        //create a portfolio
        Portfolio myPortfolio = new Portfolio("My Portfolio","Estifanos");

        //Add fixed assets
        myPortfolio.addAsset(new Jewellery("Dimond Ring",5000,1.2));
        myPortfolio.addAsset(new House("Family House",1250000,2005,2500,4));
        myPortfolio.addAsset(new Gold("Gold Bar",10000,2.5));

        //Add Liquid assets
        myPortfolio.addAsset(new BankAccount("Checking Account","123456",12000));
        myPortfolio.addAsset(new CreditCard("Visa Card", "987654", -3000)); // debt

        // Print total portfolio value
        System.out.println("Total Portfolio Value: $" + myPortfolio.getValue());

        // Print most and least valuable assets
        System.out.println("Most Valuable Asset: " + myPortfolio.getMostValuable().getClass().getSimpleName());
        System.out.println("Least Valuable Asset: " + myPortfolio.getleastValuable().getClass().getSimpleName());

    }
}
