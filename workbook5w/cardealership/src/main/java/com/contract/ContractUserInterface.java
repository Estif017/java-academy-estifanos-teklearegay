package com.contract;

import com.dealership.Dealership;
import com.dealership.DealershipFileManager;
import com.helperMethods.HelperMethod;
import com.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
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
//        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = HelperMethod.generateRandomDate(2023,2025);

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
        System.out.println("1. Sell/Lease a Vehicle");
        System.out.println("2. List Contracts");
        int choice = scanner.nextInt();
        if(choice==1){
            startContractProcess();
        }else{
            System.out.println("1.All Contracts");
            System.out.println("2.Lease Contract");
            System.out.println("3.Sale Contract");
            int listChoice = scanner.nextInt();

            List<Contract> contracts = ContractFileManager.readContracts();
            if(listChoice==1){
                ContractFileManager.displayContracts(contracts);
            } else if (listChoice==2) {
                displayContractsByType(contracts,LeaseContract.class);
            } else if (listChoice==3) {
                displayContractsByType(contracts,SalesContract.class);
            }
        }
    }

    public void displayContractsByType(List<Contract> contracts, Class<?> contractType){
        List<Contract> filteredContracts = new ArrayList<>();
        for (Contract contract : contracts) {
            if (contractType.isInstance(contract)) {
                filteredContracts.add(contract);
            }
        }
        ContractFileManager.displayContracts(filteredContracts);
    }


}
