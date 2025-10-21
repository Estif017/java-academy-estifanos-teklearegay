package com.blackJack;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand(){
        cards = new ArrayList<>();
    }

    public int getValue(){
        int value = 0;

        for(Card card: cards){
            value += card.getPointValue();
        }
        return value;
    }

    public void deal(Card card){
        cards.add(card);
    }
}
