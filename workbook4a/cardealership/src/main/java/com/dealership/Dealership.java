package com.dealership;

import com.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Vehicle> getVehiclesByPrice(double min,double max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min,int max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min,int max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        return vehicles;
    }

    public ArrayList<Vehicle> getAllVehicles(){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.remove(vehicle);
    }
}
