package com.blackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("How many players will be playing");
        Scanner scanner = new Scanner(System.in);
        int number_of_players = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Hand> players = new ArrayList<>();
        for (int i = 0; i < number_of_players; i++) {
            players.add(new Hand());
        }
        deck.shuffle();
        for (int i = 0; i < 2; i++) {
            int playerNumber=1;
            for (Hand player : players) {
                Card card = deck.deal();
                player.deal(card);
                System.out.println("player "+playerNumber+" get number "+card.getValue());
                playerNumber++;
                deck.shuffle();
            }
        }
        System.out.println(players);
        for (Hand player : players) {
            System.out.println(player.getValue());
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

        if (winnerIndex != -1) {
            System.out.println("Player " + (winnerIndex + 1) + " wins with " + highestScore + " points!");
        } else {
            System.out.println("No winner. All players busted.");
        }
    }
}
