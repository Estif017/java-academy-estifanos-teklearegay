package com.dealership;

import com.vehicle.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
    public  Dealership getDealership(){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Dealership dealership;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
            String firstLine  = reader.readLine();
            String[] dealerInfo = firstLine.split("\\|");
            String name = dealerInfo[0];
            String address = dealerInfo[1];
            String phone = dealerInfo[2];
            dealership = new Dealership(name,address,phone);
            String line;
            while((line= reader.readLine())!=null){
                if(line.trim().isEmpty()) continue;
                String[] parts = line.split("\\|");
                if(parts.length==8){
                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);
                    Vehicle vehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
                    vehicles.add(vehicle);
                }
            }
            reader.close();
            for(Vehicle vehicle: vehicles){
                dealership.addVehicle(vehicle);
            }
            return dealership;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveDealership(Dealership dealership){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv"));//overwrite mode
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            //overwrite mode
            //write each vehicle
            for(Vehicle v:dealership.getInventory()){
                writer.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" +
                        v.getModel() + "|" + v.getVehicleType() + "|" + v.getColor() + "|" +
                        v.getOdometer() + "|" + v.getPrice());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
