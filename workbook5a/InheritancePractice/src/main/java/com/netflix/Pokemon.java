package com.netflix;

public abstract class Pokemon {
    private String energyType;
    private String name;

    public Pokemon(String name) {
        this.name = name;
    }

    public String getEnergyType() {
        return energyType;
    }

    public void setEnergyType(String energyType) {
        this.energyType = energyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract String attack();
}
