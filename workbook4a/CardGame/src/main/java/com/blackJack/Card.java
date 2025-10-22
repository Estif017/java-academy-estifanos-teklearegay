package com.blackJack;

public class Card {
    private String suit;
    private String value;

    public Card(String suit, String value){
        this.suit = suit;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getSuit() {
        return suit;
    }

    public int getPointValue(){
        switch (this.value){
            case "A": return 11;
            case "K":
            case "Q":
            case "J": return 10;
            default: return Integer.parseInt(this.value);
        }
    }
    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
