package com.pluralsight;

import java.util.Scanner;

public class MovieNight {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the movie title? ");
        String movieTitle = scanner.nextLine();

        System.out.println("How many people will be there? ");
        int numberOfFriends = scanner.nextInt();

        System.out.println("How many pizza will be there");
        int numberOfPizza = scanner.nextInt();
        scanner.nextLine();

        System.out.println("How much is the pizza cost? ");
        double pizzaPrice = scanner.nextDouble();

        System.out.println("Is there a popcorn? (Enter true or false) ");
        boolean havePopcorn = scanner.nextBoolean();
        double totalPopcornPrice = 0;
        if(havePopcorn){
            System.out.println("How many people want popcorn? ");
            int peopleWantsPopcorn = scanner.nextInt();
            scanner.nextLine();
            totalPopcornPrice = peopleWantsPopcorn * 3.50;
        }

        System.out.println("🎬 Tonight's movie: " + movieTitle);
        System.out.println("👥 Number of friends: " + numberOfFriends);
        System.out.println("🍕 Pizza price per piece: $" + pizzaPrice);

        int totalPeople = numberOfFriends + 1;
        double totalPizzaCost = Math.round(numberOfPizza * pizzaPrice);
        if(totalPizzaCost>30){
            System.out.println("Whoa, that's a lot of pizza! 🍕");
        }else{
            System.out.println("Nice budget-friendly movie night!");
        }

        System.out.println("💰 Total pizza cost for " + totalPeople + " people: $" + totalPizzaCost);
        System.out.println("How much the drink cost? ");
        double drinkPrice = scanner.nextDouble();
        double totalDrinkPrice = drinkPrice * totalPeople;
        double totalCost = totalDrinkPrice + totalPizzaCost + totalPopcornPrice;

        System.out.printf("Movie: %s | Guests: %d | Total cost: €%.2f%n",
                movieTitle, totalPeople, totalCost);

        scanner.close();
    }
}



