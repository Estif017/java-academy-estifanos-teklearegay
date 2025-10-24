package com.dealership;

import com.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Dealership dealership;


    public void Display(){
        init();
        boolean running = true;

        while (running){
            System.out.println("\n=== Dealership Menu ===");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make / model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1-> processGetByPriceRequest();
                case 2-> processGetByMakeModelRequest();
                case 3-> processGetByYearRequest();
                case 4-> processGetByColorRequest();
                case 5-> processGetByMileageRequest();
                case 6-> processGetByVehicleTypeRequest();
                case 7-> processGetAllVehicleRequest();
                case 8-> processAddVehicleRequest();
                case 9-> processRemoveVehicleRequest();
                case 99->{
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                }
                default->System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    private void init(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
        System.out.println("✅ Dealership data loaded successfully.");
    }
    private void displayVehicles(ArrayList<Vehicle> vehicles){
        if(vehicles == null || vehicles.isEmpty()){
            System.out.println("No vehicles found.");
            return;
        }else{
            System.out.println("\n=== Vehicle List ===");
            for(Vehicle vehicle: vehicles){
                System.out.println(vehicle.toString());
            }
        }
    }
    private int safeIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("⚠️ Please enter a valid number.");
            scanner.nextLine();
            System.out.print("Try again: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        return value;
    }

    private double safeDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("⚠️ Please enter a valid decimal number.");
            scanner.nextLine();
            System.out.print("Try again: ");
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    private String capitalize(String input) {
        if (input == null || input.isBlank()) return "";
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public void processGetByPriceRequest(){
        System.out.println("Enter the minimum amount (press Enter if no minimum amount):");
        double min = safeDoubleInput();

        System.out.println("Enter the maximum amount (press Enter if no maximum amount):");
        double max = safeDoubleInput();
        ArrayList<Vehicle> result = dealership.getVehiclesByPrice(min,max);
        System.out.println(result);
    }
    public void processGetByMakeModelRequest(){
        System.out.println("Enter the make of the car: ");
        String make = capitalize(scanner.nextLine());

        System.out.println("Enter the model of the car");
        String model = capitalize(scanner.nextLine());

        System.out.println(dealership.getVehiclesByMakeModel(make,model));
    }
    public void processGetByColorRequest(){
        System.out.println("Please enter the vehicle color ");
        String color = capitalize(scanner.nextLine());

        System.out.println(dealership.getVehiclesByColor(color));
    }
    public void processGetByYearRequest(){
        System.out.println("Enter the minimum year (press Enter if no minimum year):");
        int minyear = safeIntInput();

        System.out.println("Enter the maximum year (press Enter if no maximum year):");
        int maxyear = safeIntInput();
        System.out.println(dealership.getVehiclesByYear(minyear,maxyear));
    }
    public void processGetByMileageRequest(){
        System.out.println("Enter the minimum mileage (press Enter if no minimum mileage):");
        int minMileage = safeIntInput();

        System.out.println("Enter the maximum mileage (press Enter if no maximum mileage):");
        int maxMilage = safeIntInput();
        System.out.println(dealership.getVehiclesByMileage(minMileage,maxMilage));
    }
    public void processGetByVehicleTypeRequest(){
        System.out.println("Please enter the vehicle type");
        String type = capitalize(scanner.nextLine());

        System.out.println(dealership.getVehiclesByType(type));
    }
    public void processGetAllVehicleRequest(){
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }
    public void processAddVehicleRequest(){
        System.out.println("Enter VIN: ");
        int vin = safeIntInput();
        System.out.println("Enter Year: ");
        int year = safeIntInput();
        System.out.println("Enter Make: ");
        String make = capitalize(scanner.nextLine());
        System.out.println("Enter Model: ");
        String model = capitalize(scanner.nextLine());
        System.out.println("Enter Type: ");
        String type = capitalize(scanner.nextLine());
        System.out.println("Enter Color: ");
        String color = capitalize(scanner.nextLine());
        System.out.println("Enter Odometer: ");
        int odometer = safeIntInput();
        System.out.println("Enter Price: ");
        double price = safeDoubleInput();

        Vehicle newVehicle = new Vehicle(vin,year,make,model,type,color,odometer,price);
        dealership.addVehicle(newVehicle);
        DealershipFileManager.saveDealership(dealership);
        System.out.println("✅ Vehicle added successfully.");
    }
    public void processRemoveVehicleRequest(){
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = scanner.nextInt(); scanner.nextLine();
        Vehicle toRemove = null;
        for(Vehicle vehicle : dealership.getInventory()){
            if(vin==vehicle.getVin()){
                toRemove=vehicle;
                break;
            }
        }

        if(toRemove!=null){
            dealership.removeVehicle(toRemove);
            DealershipFileManager.saveDealership(dealership);
            System.out.println("🚗 Vehicle removed successfully.");
        }else{
            System.out.println("No vehicle found with VIN " + vin);
        }
    }
}
