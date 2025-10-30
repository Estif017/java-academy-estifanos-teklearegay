package com.pluralsight.finance;

public class House extends FixedAsset {
    private int yearBuilt;
    private int squarefeet;
    private int bedrooms;

    public House(String name, double marketValue, int yearBuilt, int squarefeet, int bedrooms) {
        super(name, marketValue);
        this.yearBuilt = yearBuilt;
        this.squarefeet = squarefeet;
        this.bedrooms = bedrooms;
    }

    @Override
    public double getValue() {
        return super.getValue();
    }
}
