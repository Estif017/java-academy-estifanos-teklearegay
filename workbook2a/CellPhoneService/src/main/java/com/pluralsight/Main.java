package com.pluralsight;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("What is the serial number?");
        double serialNumber = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("What model is the phone?");
        String model = scanner.nextLine();
        System.out.print("Who is the carrier?");
        String carrier = scanner.nextLine();
        System.out.print("What is the phone number?");
        String phoneNumber = scanner.nextLine();
        System.out.print("Who is the owner of the phone?");
        String owner = scanner.nextLine();
        CellPhone phone = new CellPhone(serialNumber,model,carrier,phoneNumber,owner);
        display(phone);
    }

    public static void display(CellPhone phone){
        phone.dial();
        System.out.println("This phone with a serial number "+phone.getSerialNumber()+" is belong to "+phone.getOwner()+" the number is "+phone.getPhoneNumber()+" with a "+phone.getCarrier());
    }
}