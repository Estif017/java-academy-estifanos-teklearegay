package com.pluralsight;

import com.pluralsight.finance.FixedAsset;

import java.util.ArrayList;

public class Portfolio {
    private String name;
    private String owner;
    private ArrayList<FixedAsset> assets = new ArrayList<>();

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public void addAsset(FixedAsset asset){
        assets.add(asset);
    }

    public double getValue(){
        double totalMarketValue = 0;
        for(FixedAsset asset:assets){
            totalMarketValue+=asset.getValue();
        }
        return totalMarketValue;
    }
}
