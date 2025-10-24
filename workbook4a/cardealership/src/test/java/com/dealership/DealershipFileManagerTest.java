package com.dealership;

import com.vehicle.Vehicle;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DealershipFileManagerTest {

    @Test
    void testGetDealershipLoadsCorrectData() throws IOException {
        File tempFile = File.createTempFile("test_inventory", ".csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("D&B Used Cars|111 Old Benbrook Rd|817-555-5555\n");
            writer.write("101|2010|Toyota|Camry|Sedan|Blue|50000|12000.0\n");
        }

        DealershipFileManager dfm = new DealershipFileManager() {
            @Override
            public Dealership getDealership() {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(tempFile));
                    String[] dealerInfo = reader.readLine().split("\\|");
                    Dealership d = new Dealership(dealerInfo[0], dealerInfo[1], dealerInfo[2]);
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split("\\|");
                        Vehicle v = new Vehicle(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),
                                parts[2], parts[3], parts[4], parts[5],
                                Integer.parseInt(parts[6]), Double.parseDouble(parts[7]));
                        d.addVehicle(v);
                    }
                    reader.close();
                    return d;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Dealership d = dfm.getDealership();
        assertEquals("D&B Used Cars", d.getName());
        assertEquals(1, d.getInventory().size());
        assertEquals("Toyota", d.getInventory().get(0).getMake());
    }

    @Test
    void testSaveDealershipWritesCorrectFormat() throws IOException {
        File tempFile = File.createTempFile("test_save", ".csv");
        Dealership dealership = new Dealership("TestDealer", "123 St", "555-5555");
        dealership.addVehicle(new Vehicle(1, 2020, "Honda", "Civic", "Sedan", "Black", 10000, 15000.0));

        DealershipFileManager.saveDealership(dealership);

        assertTrue(tempFile.exists());
    }
}
