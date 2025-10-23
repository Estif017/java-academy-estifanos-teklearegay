package com.dealership;

import com.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }


    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> sortedVehicles = new ArrayList<>();
        for(Vehicle vehicle : this.inventory){
            if(vehicle.getPrice()>min && vehicle.getPrice()<max){
                sortedVehicles.add(vehicle);
            }
        }
        return sortedVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> searchedVehicles = new ArrayList<>();
        for(Vehicle vehicle : this.inventory){
            if(vehicle.getMake().equalsIgnoreCase(make)&& vehicle.getModel().equalsIgnoreCase(model)){
                searchedVehicles.add(vehicle);
            }
        }
        return searchedVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min,int max){
        ArrayList<Vehicle> yearSortedVehicles = new ArrayList<>();
        for(Vehicle vehicle: this.inventory){
            if(vehicle.getYear()>min&&vehicle.getYear()<max){
                yearSortedVehicles.add(vehicle);
            }
        }
        return yearSortedVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> colorSortedVehicles = new ArrayList<>();
        for(Vehicle vehicle: this.inventory){
            if(vehicle.getColor().equalsIgnoreCase(color)){
                colorSortedVehicles.add(vehicle);
            }
        }
        return colorSortedVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min,int max){
        ArrayList<Vehicle> mileAgeSortedVehicles = new ArrayList<>();
        for(Vehicle vehicle : this.inventory){
            if(vehicle.getOdometer()>min && vehicle.getOdometer()<max){
                mileAgeSortedVehicles.add(vehicle);
            }
        }
        return mileAgeSortedVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){
        ArrayList<Vehicle> typeSortedVehicles = new ArrayList<>();
        for(Vehicle vehicle: this.inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                typeSortedVehicles.add(vehicle);
            }
        }
        return typeSortedVehicles;
    }

    public ArrayList<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        this.inventory.remove(vehicle);
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
