package com.contract;

import com.dealership.Dealership;
import com.dealership.DealershipFileManager;
import com.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

import static com.helperMethods.HelperMethod.safeIntInput;

public class ContractUserInterface {
//    private Contract contract;
    private final Scanner scanner = new Scanner(System.in);

    private void startContractProcess(){
        System.out.print("Enter VIN of vehicle to sell/lease: ");
        int vin = safeIntInput();

        DealershipFileManager dfm = new DealershipFileManager();
        Dealership dealership =dfm.getDealership();

        Vehicle selectedVehicle = dealership.getInventory().stream().filter(
                vehicle -> vehicle.getVin()==vin
        ).findFirst().orElse(null);
        if(selectedVehicle==null){
            System.out.println("⚠️ Vehicle not found.");
            return;
        }
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        System.out.print("1 = Sale, 2 = Lease: ");
        int type = safeIntInput();
        Contract contract = (type==1)
                ? new SalesContract(date,name,email,selectedVehicle,askIfFinanced())
                : new LeaseContract(date,name,email,selectedVehicle);

        ContractFileManager.saveContract(contract);
        dealership.removeVehicle(selectedVehicle);
        DealershipFileManager.saveDealership(dealership);
        System.out.println("✅ Contract completed and vehicle removed from inventory.");
    }

    private boolean askIfFinanced() {
        System.out.print("Is this vehicle financed (yes/no)? ");
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }

    public void display() {
        System.out.println("Welcome to the Dealership Contract System!");
        System.out.println("Please choose an option:");
        System.out.println("1. Sell a Vehicle");
        System.out.println("2. Lease a Vehicle");
        startContractProcess();
    }


}
