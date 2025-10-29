package com.contract;

import com.vehicle.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager {
    public static void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contract.csv", true))) {
            if (contract instanceof SalesContract sc) {
                String financed = sc.isFinanced() ? "YES" : "NO";
                writer.write(String.format(
                        "SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f%n",
                        contract.getDateOfContract(), contract.getCustomerName(), contract.getCustomerEmail(),
                        contract.getVehicleSold().getVin(), contract.getVehicleSold().getYear(),
                        contract.getVehicleSold().getMake(), contract.getVehicleSold().getModel(),
                        contract.getVehicleSold().getVehicleType(), contract.getVehicleSold().getColor(),
                        contract.getVehicleSold().getOdometer(), contract.getVehicleSold().getPrice(),
                        sc.getSalesTax(), sc.getRecordingFee(), sc.getProcessingFee(),
                        contract.getTotalPrice(), financed, contract.getMonthlyPayment()
                ));
            } else if (contract instanceof LeaseContract lc) {
                writer.write(String.format(
                        "LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f%n",
                        contract.getDateOfContract(), contract.getCustomerName(), contract.getCustomerEmail(),
                        contract.getVehicleSold().getVin(), contract.getVehicleSold().getYear(),
                        contract.getVehicleSold().getMake(), contract.getVehicleSold().getModel(),
                        contract.getVehicleSold().getVehicleType(), contract.getVehicleSold().getColor(),
                        contract.getVehicleSold().getOdometer(), contract.getVehicleSold().getPrice(),
                        lc.getExpectedEndingValue(), lc.getLeaseFee(), contract.getTotalPrice(), contract.getMonthlyPayment()
                ));
            }
        } catch (IOException e) {
            System.err.println("❌ Error writing to contract.csv: " + e.getMessage());
        }
    }

    public static List<Contract> readContracts() {
        List<Contract> contracts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("contract.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 0) continue;

                String contractType = parts[0].trim();

                if (contractType.equalsIgnoreCase("SALE")) {
                    // SALE|Date|Name|Email|VIN|Year|Make|Model|Type|Color|Odometer|Price|Tax|RecordingFee|ProcessingFee|Total|Financed|MonthlyPayment
                    if (parts.length >= 18) {
                        String date = parts[1];
                        String name = parts[2];
                        String email = parts[3];
                        int vin = Integer.parseInt(parts[4]);
                        int year = Integer.parseInt(parts[5]);
                        String make = parts[6];
                        String model = parts[7];
                        String type = parts[8];
                        String color = parts[9];
                        int odometer = Integer.parseInt(parts[10]);
                        double price = Double.parseDouble(parts[11]);
                        boolean financed = parts[16].equalsIgnoreCase("YES");

                        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                        SalesContract sale = new SalesContract(date, name, email, vehicle,financed);
                        contracts.add(sale);
                    }

                } else if (contractType.equalsIgnoreCase("LEASE")) {
                    // LEASE|Date|Name|Email|VIN|Year|Make|Model|Type|Color|Odometer|Price|EndingValue|LeaseFee|Total|Monthly
                    if (parts.length >= 16) {
                        String date = parts[1];
                        String name = parts[2];
                        String email = parts[3];
                        int vin = Integer.parseInt(parts[4]);
                        int year = Integer.parseInt(parts[5]);
                        String make = parts[6];
                        String model = parts[7];
                        String type = parts[8];
                        String color = parts[9];
                        int odometer = Integer.parseInt(parts[10]);
                        double price = Double.parseDouble(parts[11]);

                        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                        LeaseContract lease = new LeaseContract(date, name, email, vehicle);
                        contracts.add(lease);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("❌ Error reading contract.csv: " + e.getMessage());
        }

        return contracts;
    }

    public static void displayContracts(List<Contract> contracts) {
        System.out.println("\n╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-6s │ %-10s │ %-15s │ %-20s │ %-7s │ %-6s │ %-10s │ %-10s │ %-8s │ %-10s │ %-10s │ %-10s │ %-12s │ %-14s ║%n",
                "Type", "Date", "Customer Name", "Customer Email", "VIN", "Year", "Make", "Model",
                "Type", "Color", "Mileage", "Price($)", "Total($)", "Monthly($)");
        System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

        for (Contract c : contracts) {
            Vehicle v = c.getVehicleSold();
            String type = c instanceof SalesContract ? "SALE" : "LEASE";
            double monthly = 0.0;

            if (c instanceof SalesContract sc) {
                monthly = sc.isFinanced() ? sc.getMonthlyPayment() : 0.0;
            } else if (c instanceof LeaseContract lc) {
                monthly = lc.getMonthlyPayment();
            }

            System.out.printf("║ %-6s │ %-10s │ %-15s │ %-20s │ %-7d │ %-6d │ %-10s │ %-10s │ %-8s │ %-10s │ %-10d │ %-10.2f │ %-12.2f │ %-14.2f ║%n",
                    type,
                    c.getDateOfContract(),
                    c.getCustomerName(),
                    c.getCustomerEmail(),
                    v.getVin(),
                    v.getYear(),
                    v.getMake(),
                    v.getModel(),
                    v.getVehicleType(),
                    v.getColor(),
                    v.getOdometer(),
                    v.getPrice(),
                    c.getTotalPrice(),
                    monthly
            );
        }

        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }
}
