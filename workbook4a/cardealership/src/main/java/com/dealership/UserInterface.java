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
    public void processGetByPriceRequest(){
        System.out.println("Enter the minimum amount (press Enter if no minimum amount):");
        double min = scanner.nextDouble();

        System.out.println("Enter the maximum amount (press Enter if no maximum amount):");
        double max = scanner.nextDouble();
        ArrayList<Vehicle> result = dealership.getVehiclesByPrice(min,max);
        System.out.println(result);
    }
    public void processGetByMakeModelRequest(){
        System.out.println("Enter the make of the car: ");
        String make = scanner.nextLine();

        System.out.println("Enter the model of the car");
        String model = scanner.nextLine();

        System.out.println(dealership.getVehiclesByMakeModel(make,model));
    }
    public void processGetByColorRequest(){
        System.out.println("Please enter the vehicle color ");
        String color = scanner.nextLine();

        System.out.println(dealership.getVehiclesByColor(color));
    }
    public void processGetByYearRequest(){
        System.out.println("Enter the minimum year (press Enter if no minimum year):");
        int minyear = scanner.nextInt();

        System.out.println("Enter the maximum year (press Enter if no maximum year):");
        int maxyear = scanner.nextInt();
        System.out.println(dealership.getVehiclesByYear(minyear,maxyear));
    }
    public void processGetByMileageRequest(){
        System.out.println("Enter the minimum mileage (press Enter if no minimum mileage):");
        int minMileage = scanner.nextInt();

        System.out.println("Enter the maximum mileage (press Enter if no maximum mileage):");
        int maxMilage = scanner.nextInt();
        System.out.println(dealership.getVehiclesByMileage(minMileage,maxMilage));
    }
    public void processGetByVehicleTypeRequest(){
        System.out.println("Please enter the vehicle type");
        String type = scanner.nextLine();

        System.out.println(dealership.getVehiclesByType(type));
    }
    public void processGetAllVehicleRequest(){
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }
    public void processAddVehicleRequest(){
        System.out.println("Enter VIN: ");
        int vin = scanner.nextInt(); scanner.nextLine();
        System.out.println("Enter Year: ");
        int year = scanner.nextInt(); scanner.nextLine();
        System.out.println("Enter Make: ");
        String make = scanner.nextLine();
        System.out.println("Enter Model: ");
        String model = scanner.nextLine();
        System.out.println("Enter Type: ");
        String type = scanner.nextLine();
        System.out.println("Enter Color: ");
        String color = scanner.nextLine();
        System.out.println("Enter Odometer: ");
        int odometer = scanner.nextInt(); scanner.nextLine();
        System.out.println("Enter Price: ");
        double price = scanner.nextDouble(); scanner.nextLine();

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
