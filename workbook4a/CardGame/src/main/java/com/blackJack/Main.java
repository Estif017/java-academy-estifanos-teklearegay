package com.blackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deck deck = new Deck();
        deck.shuffle();

        System.out.println("Welcome to BlackJack!");
        System.out.println("How many players will be playing");
        int number_of_players = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Hand> players = new ArrayList<>();
        for (int i = 0; i < number_of_players; i++) {//creating a hand for each player
            players.add(new Hand());
        }

        for (int i = 0; i < 2; i++) {//giving 2 cards
            for (Hand player : players) {//for each players
                Card card = deck.deal();//remove card from the deck
                player.addCard(card);//give the card to player(hand)
            }
        }

        //Each players takes turn
        for(int i=0;i<players.size();i++){
            Hand playerHand = players.get(i);// player cards
            boolean stay = false;

            System.out.println("\n=== Player " + (i + 1) + " Turn ===");
            while (!stay && !playerHand.isBusted()){
                System.out.println("Your hand: "+ playerHand);
                System.out.println("Total value: "+ playerHand.getValue());
                System.out.print("Do you want to (H)it or (S)tay? ");
                String choice = scanner.nextLine().trim().toLowerCase();
                if(choice.equals("h")){
                    Card newCard = deck.deal();
                    System.out.println("You drew "+ newCard);
                    playerHand.addCard(newCard);
                } else if (choice.equals("s")) {
                    stay=true;
                    System.out.println("You chose to stay.");
                }else {
                    System.out.println("Invalid choice. Please enter H or S.");
                }
            }
            if(playerHand.isBusted()){
                System.out.println("Player " + (i + 1) + " BUSTED with " + playerHand.getValue() + "!");
            }else{
                System.out.println("Player " + (i + 1) + " ends with " + playerHand.getValue() + ".");
            }
        }

        determineWinner(players);

    }

    public static void determineWinner(List<Hand> players){

        int highestScore = 0;
        int winnerIndex = -1;

        for (int i = 0; i < players.size(); i++) {
            int score = players.get(i).getValue();
            if (score <= 21 && score > highestScore) {
                highestScore = score;
                winnerIndex = i;
            }
        }

        System.out.println("\n=== FINAL RESULTS ===");
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Player " + (i + 1) + ": " + players.get(i) + " (" + players.get(i).getValue() + ")");
        }

        if (winnerIndex != -1) {
            System.out.println("\n🏆 Player " + (winnerIndex + 1) + " wins with " + highestScore + " points!");
        } else {
            System.out.println("\nNo winner — everyone busted!");
        }
    }
}
