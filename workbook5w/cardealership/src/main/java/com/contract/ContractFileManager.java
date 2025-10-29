package com.contract;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
}
