package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        /*Todo: A powerPuff fighting game
        *   Features:
        *       Play online
        *       customizing characters
        *       Customs
        *       Solo mode
        *       Finishing Moves
        *        Team attack
        *         Dialog
        *         Health boost*/

        // Create characters
        PowerPuffGirl blossom = new PowerPuffGirl("Blossom", "Pink");
        PowerPuffGirl bubbles = new PowerPuffGirl("Bubbles", "Blue");
        PowerPuffGirl buttercup = new PowerPuffGirl("Buttercup", "Green");

        // Show initial stats
        System.out.println("=== Initial Stats ===");
        System.out.println(blossom);
        System.out.println(bubbles);
        System.out.println(buttercup);

        // Healing example
        System.out.println("\n--- Healing Blossom ---");
        blossom.heal(50); // heal 50 points
        System.out.println(blossom);

        blossom.heal(150); // try to overheal
        System.out.println(blossom);

        // Simulate a small battle
        System.out.println("\n=== Battle Simulation ===");
        blossom.attack(buttercup);
        buttercup.attack(bubbles);
        bubbles.heal(30);
        blossom.attack(buttercup);

        // Show final stats
        System.out.println("\n=== Final Stats ===");
        System.out.println(blossom);
        System.out.println(bubbles);
        System.out.println(buttercup);
    }
}
