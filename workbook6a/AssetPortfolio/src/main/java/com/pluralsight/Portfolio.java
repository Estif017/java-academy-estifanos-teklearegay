package com.pluralsight;

import com.pluralsight.finance.FixedAsset;
import com.pluralsight.finance.Jewellery;
import com.pluralsight.finance.Valuable;

import java.util.ArrayList;

public class Portfolio implements Valuable {
    private String name;
    private String owner;
    private ArrayList<Valuable> assets = new ArrayList<>();

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public void addAsset(Valuable asset){
        assets.add(asset);
    }

    public double getValue(){
        double totalMarketValue = 0;
        for(Valuable asset:assets){
            totalMarketValue+=asset.getValue();
        }
        return totalMarketValue;
    }

    public Valuable getMostValuable(){
        double mostValuable = assets.get(0).getValue();
        Valuable mostValuableAsset = assets.get(0);
        for(Valuable asset:assets){
            if(mostValuable<asset.getValue()){
                mostValuable= asset.getValue();
                mostValuableAsset=asset;

            }
        }
        return mostValuableAsset;
    }
    public Valuable getleastValuable(){
        double leastValuable = assets.get(0).getValue();
        Valuable leastValuableAsset = assets.get(0);
        for(Valuable asset:assets){
            if(leastValuable>asset.getValue()){
                leastValuable = asset.getValue();
                leastValuableAsset =asset;

            }
        }
        return leastValuableAsset;
    }
}
