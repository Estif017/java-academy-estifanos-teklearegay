package com.pluralsight.finance;

public abstract class FixedAsset {
    private String name;
    private double marketValue;

    public FixedAsset(String name, double marketValue) {
        this.name = name;
        this.marketValue = marketValue;
    }

    public double getValue(){
        return marketValue;
    }
}
