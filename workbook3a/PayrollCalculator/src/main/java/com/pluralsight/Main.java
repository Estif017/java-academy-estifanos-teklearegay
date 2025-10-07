package com.pluralsight;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)  {
        // 1️⃣ Ask user for input and output filenames
        System.out.print("Enter the name of the employee file to process: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Enter the name of the payroll file to create: ");
        String outputFileName = scanner.nextLine();

        //2️⃣ Read employees from file
        Employee[] employees = readEmployees(inputFileName);

        if(employees == null){
            System.out.println("Could not read employees. Exiting program.");
            return;
        }

        // 3️⃣ Write payroll to CSV or JSON depending on file extension
        String outPutPath = "src/main/resources/"+outputFileName;
        if (outputFileName.toLowerCase().endsWith(".json")) {
            writePayrollJson(employees, outPutPath);
        } else {
            writePayrollCsv(employees, outPutPath);
        }

        System.out.println("Payroll file created: " + outputFileName);

    }


    public static Employee[] readEmployees(String fileName) {
        try {
            BufferedReader reader;

            // ✅ First: Try to find the file in the filesystem
            File file = new File(fileName);
            if (file.exists()) {
                reader = new BufferedReader(new FileReader(file));
            } else {
                // ✅ If not found, try to load from the classpath (resources)
                InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(fileName);
                if (inputStream == null) {
                    System.out.println(fileName + " (The system cannot find the file specified)");
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));
            }

            // ✅ Count number of data lines (skip header)
            int count = 0;
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                if (!line.trim().isEmpty()) count++;
            }

            // ✅ Create an Employee array
            Employee[] employees = new Employee[count];

            // ✅ Reset reader (reopen the file)
            if (file.exists()) {
                reader = new BufferedReader(new FileReader(file));
            } else {
                InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(fileName);
                reader = new BufferedReader(new InputStreamReader(inputStream));
            }

            // ✅ Read again to fill the array
            firstLine = true;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // skip header
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length < 4) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                double hours = Double.parseDouble(parts[2].trim());
                double rate = Double.parseDouble(parts[3].trim());

                Employee emp = new Employee(id, hours, rate);
                emp.setName(name);
                employees[index++] = emp;
            }

            reader.close();
            return employees;

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }


    public static void writePayrollCsv(Employee[] employees, String fileName){
        try{
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            writer.println("id|name|gross pay");

            for (Employee emp: employees){
                double grossPay = emp.getGrossPay();
                writer.printf("%d|%s|%.2f%n",emp.getEmployeeId(),emp.getName(),grossPay);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public static void writePayrollJson(Employee[] employees, String fileName) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            writer.println("[");
            for (int i = 0; i < employees.length; i++) {
                Employee emp = employees[i];
                double grossPay = emp.getGrossPay();
                writer.printf("  { \"id\": %d, \"name\": \"%s\", \"grossPay\": %.2f }",
                        emp.getEmployeeId(), emp.getName(), grossPay);
                if (i < employees.length - 1)
                    writer.println(",");
                else
                    writer.println();
            }
            writer.println("]");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
        }
    }
}