package com.netflix;

public class Mewto extends Pokemon {
    public Mewto(String name ){
        super(name);
    }
    @Override
    public String attack(){
        System.out.println("Attack");
        return "";
    }
}
