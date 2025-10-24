package com.vehicle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @Test
    void testVehicleCreation() {
        Vehicle v = new Vehicle(1234, 2020, "Toyota", "Camry", "Sedan", "Blue", 15000, 25000.0);
        assertEquals(1234, v.getVin());
        assertEquals(2020, v.getYear());
        assertEquals("Toyota", v.getMake());
        assertEquals("Camry", v.getModel());
        assertEquals("Sedan", v.getVehicleType());
        assertEquals("Blue", v.getColor());
        assertEquals(15000, v.getOdometer());
        assertEquals(25000.0, v.getPrice());
    }

    @Test
    void testVehicleToStringFormat() {
        Vehicle v = new Vehicle(111, 2021, "Honda", "Civic", "SUV", "Red", 20000, 18000.50);
        String result = v.toString();
        assertTrue(result.contains("VIN: 111"));
        assertTrue(result.contains("Year: 2021"));
        assertTrue(result.contains("Make: Honda"));
        assertTrue(result.contains("Model: Civic"));
    }
}
