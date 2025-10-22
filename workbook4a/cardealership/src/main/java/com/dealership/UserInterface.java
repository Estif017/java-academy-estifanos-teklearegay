package com.dealership;

import com.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public void UserInterface(){}
    private void init(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
        System.out.println("✅ Dealership data loaded successfully.");
    }
//    init()
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
                case 1:
                    // processGetByPriceRequest();
                    break;
                case 2:
                    // processGetByMakeModelRequest();
                    break;
                case 3:
                    // processGetByYearRequest();
                    break;
                case 4:
                    // processGetByColorRequest();
                    break;
                case 5:
                    // processGetByMileageRequest();
                    break;
                case 6:
                    // processGetByTypeRequest();
                    break;
                case 7:
                    processGetAllVehicleRequest();
                    break;
                case 8:
                    // processAddVehicleRequest();
                    break;
                case 9:
                    // processRemoveVehicleRequest();
                    break;
                case 99:
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

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
    public void processGetByPriceRequest(){}
    public void processGetMakeModelRequest(){}
    public void processGetByColorRequest(){}
    public void processGetByYearRequest(){}
    public void processGetByMileageRequest(){}
    public void processGetByVehicleTypeRequest(){}
    public void processGetAllVehicleRequest(){
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }
    public void processAddVehicleRequest(){}
    public void processRemoveVehicleRequest(){}
}
