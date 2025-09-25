package com.pluralsight;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("When is the pickup date? ");
        String pickupDate = scanner.nextLine();

        System.out.println("For how many days you need the car? ");
        int days = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Do you want an electronic toll tag for $3.95/day (yes/no)");
        String tollTag = scanner.nextLine();
        double totalTollTag = tollTag == "yes" ? days * 3.95 : 0;

        System.out.println("Do you want GPS for $2.95/day (yes/no)");
        String gps = scanner.nextLine();
        double totalGpsRate = gps == "yes" ? days * 2.95 : 0;

        System.out.println("What is your age?");
        int age = scanner.nextInt();
        if(age<25){
            System.out.println("The basic car rental is $29.99 per day. There is a 30% surcharge on the basic car\n" +
                    "rental for drivers under 25. All taxes have already been incorporated into the\n" +
                    "fees shown.");
        }

        double basicRentalRate = age < 25 ? (29.99*0.3) + 29.99 : 29.99;
        double totalRenalRate = Math.round((basicRentalRate*days)+totalTollTag+totalGpsRate);
        System.out.println("Based on the information we gathered the total due amount for this car to rent for "+days+ " days would be $"+totalRenalRate);

        scanner.close();
    }
}