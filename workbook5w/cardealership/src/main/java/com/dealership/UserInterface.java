package com.dealership;

import com.helperMethods.HelperMethod;
import com.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

import static com.helperMethods.HelperMethod.*;


public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private Dealership dealership;



    public void Display(){
        init();
        boolean running = true;

        while (running){
            displayMainMenu();

            int choice =safeIntInput();
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
            System.out.println("\n╔════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.printf("║ %-7s │ %-6s │ %-10s │ %-10s │ %-8s │ %-10s │ %-10s │ %-10s ║%n",
                    "VIN", "Year", "Make", "Model", "Type", "Color", "Mileage", "Price ($)");
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════╣");
            for(Vehicle v: vehicles){
                System.out.printf("║ %-7d │ %-6d │ %-10s │ %-10s │ %-8s │ %-10s │ %-10d │ %-10.2f ║%n",
                        v.getVin(), v.getYear(), v.getMake(), v.getModel(),
                        v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
            }
            System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════╝");
        }
    }


    public void processGetByPriceRequest(){
        System.out.println("Enter the minimum amount (press Enter if no minimum amount):");
        double min = HelperMethod.safeDoubleInput();

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

    private void displayMainMenu() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║         🚗  DEALERSHIP MAIN MENU             ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║ 1. Find Vehicles by Price Range              ║");
        System.out.println("║ 2. Find Vehicles by Make & Model             ║");
        System.out.println("║ 3. Find Vehicles by Year Range               ║");
        System.out.println("║ 4. Find Vehicles by Color                    ║");
        System.out.println("║ 5. Find Vehicles by Mileage Range            ║");
        System.out.println("║ 6. Find Vehicles by Type                     ║");
        System.out.println("║ 7. List All Vehicles                         ║");
        System.out.println("║ 8. Add a Vehicle                             ║");
        System.out.println("║ 9. Remove a Vehicle                          ║");
        System.out.println("║ 10. Sell/Lease Vehicle (Contracts)           ║");
        System.out.println("║ 99. Quit                                     ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.print("👉 Enter your choice: ");
    }
}
