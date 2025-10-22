package com.blackJack;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand(){
        cards = new ArrayList<>();
    }

    public int getValue(){
        int value = 0;
        int aceCount = 0;

        for(Card card: cards){
            value += card.getPointValue();
            if(card.getValue().equals("A")){
                aceCount++;
            }
        }
        while (value>21&&aceCount>0){
            value-=10;
            aceCount--;
        }
        return value;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public boolean isBusted(){
        return getValue()>21;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Card card:cards){
            sb.append(card.getValue()).append(" of ").append(card.getSuit()).append(", ");
        }
        if(sb.length()>2){
            sb.setLength(sb.length()-2);//remove last coma
        }
        return sb.toString();
    }
}
