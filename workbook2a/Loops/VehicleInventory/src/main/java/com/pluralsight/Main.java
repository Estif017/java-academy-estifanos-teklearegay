package com.pluralsight;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        long[] vehicleId={101121,101122,101123,101124,101125,101126};
        String[] makeModel={"Ford Explorer","Toyota Camry","Chevrolet Malibu","Honda Civic","Subaru Outback","Jeep Wrangler"};
        String[] color = {"Red","Blue","Black","White","Green","Yellow"};
        int[] odometerReading = {45000,60000,50000,70000,55000,30000};
        float[] price={13500,11000,9700,7500,14500,16000};
        boolean run = true;
        System.out.println("Enter your command: ");
        int command = scanner.nextInt();
        while (run){
            displayMenu();
            switch (command){
                case 1:
                    listAllVehicles();
                    break;
                case 2:
                    findVehiclesByPrice();
                    break;
                case 5:
                    addAVehicle();
                    break;
                case 6:
                    run = false;
                    return;
            }
        }
    }

    public  static void displayMenu(){
        System.out.println("1 - List all vehicles");
        System.out.println("2 - Search by make/model");
        System.out.println("3 - Search by price range");
        System.out.println("4 - Search by color");
        System.out.println("5 - Add a vehicle");
        System.out.println("6 - Quit");
    }

    public static  void listAllVehicles(){

    }
}