package com.pluralsight.finance;

public class Jewellery extends FixedAsset {
    private double Karat;

    public Jewellery(String name, double marketValue, double karat) {
        super(name, marketValue);
        Karat = karat;
    }

    @Override
    public double getValue(){
        return super.getValue()*this.Karat;
    }
}
