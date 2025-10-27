package com.pluralsight;

public class Cash extends Asset {
    private double cash;

    public Cash(String description, String dateAcquired, double originalCost, double cash) {
        super(description, dateAcquired, originalCost);
        this.cash = cash;
    }

    @Override
    public double getValue(){
        return cash;
    }
}
