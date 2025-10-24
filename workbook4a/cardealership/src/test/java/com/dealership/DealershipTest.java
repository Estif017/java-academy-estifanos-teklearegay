package com.dealership;

import com.vehicle.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DealershipTest {
    private Dealership dealership;
    private Vehicle car1, car2, car3;

    @BeforeEach
    void setup() {
        dealership = new Dealership("D&B Used Cars", "111 Old Benbrook Rd", "817-555-5555");
        car1 = new Vehicle(100, 2015, "Toyota", "Corolla", "Sedan", "Red", 50000, 15000);
        car2 = new Vehicle(101, 2018, "Honda", "Civic", "SUV", "Blue", 30000, 18000);
        car3 = new Vehicle(102, 2020, "Ford", "Focus", "Sedan", "Red", 10000, 20000);
        dealership.addVehicle(car1);
        dealership.addVehicle(car2);
        dealership.addVehicle(car3);
    }

    @Test
    void testAddVehicle() {
        Vehicle newCar = new Vehicle(103, 2021, "Mazda", "3", "Sedan", "White", 5000, 22000);
        dealership.addVehicle(newCar);
        assertTrue(dealership.getAllVehicles().contains(newCar));
    }

    @Test
    void testRemoveVehicle() {
        dealership.removeVehicle(car1);
        assertFalse(dealership.getAllVehicles().contains(car1));
    }

    @Test
    void testGetVehiclesByPrice() {
        ArrayList<Vehicle> result = dealership.getVehiclesByPrice(16000, 21000);
        assertEquals(2, result.size());
    }

    @Test
    void testGetVehiclesByMakeModel() {
        ArrayList<Vehicle> result = dealership.getVehiclesByMakeModel("Toyota", "Corolla");
        assertEquals(1, result.size());
    }

    @Test
    void testGetVehiclesByYear() {
        ArrayList<Vehicle> result = dealership.getVehiclesByYear(2016, 2021);
        assertEquals(2, result.size());
    }

    @Test
    void testGetVehiclesByColor() {
        ArrayList<Vehicle> result = dealership.getVehiclesByColor("Red");
        assertEquals(2, result.size());
    }

    @Test
    void testGetVehiclesByMileage() {
        ArrayList<Vehicle> result = dealership.getVehiclesByMileage(0, 40000);
        assertEquals(2, result.size());
    }

    @Test
    void testGetVehiclesByType() {
        ArrayList<Vehicle> result = dealership.getVehiclesByType("Sedan");
        assertEquals(2, result.size());
    }
}
