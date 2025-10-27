package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

// Houses
        assets.add(new House("Condo 3bd apt", "06/2024", 680000, "1234 W Manchester Blvd", 1, 500, 60));
        assets.add(new House("Townhouse 2bd", "03/2023", 520000, "5678 S Hoover St", 2, 400, 55));
        assets.add(new House("Single Family Home", "11/2022", 750000, "9101 Crenshaw Blvd", 3, 600, 70));

// Vehicles
        assets.add(new Vehicle("Electric car", "2023", 42000, "Tesla Model Y", 2023, 3500));
        assets.add(new Vehicle("Hybrid SUV", "2021", 38000, "Toyota RAV4", 2021, 120000));
        assets.add(new Vehicle("Sedan", "2019", 25000, "Honda Accord", 2019, 105000));


//        Cash
        assets.add(new Cash("Emergency Fund", "2023-05-01", 5000.00, 5000.00));

        String message = "";
        for (int i = 0; i < assets.size(); i++) {
            Asset asset = assets.get(i);
            if (asset instanceof House) {
                House house = (House) asset;
                message = "House at " + house.getAddress() + " valued at $" + house.getValue();
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                message = "Vehicle: " + vehicle.getYear() + " " + vehicle.getMakeModel() + " valued at $" + vehicle.getValue();
            }else if (asset instanceof Cash) {
                Cash cash = (Cash) asset;
                message = "Cash: " + cash.getValue();
            }
            System.out.println(message);
        }


    }
}
