package com.pluralsight;

import java.util.Scanner;

public class AddressBuilder {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StringBuilder billingInfo = new StringBuilder();
        StringBuilder shippingInfo = new StringBuilder();
        System.out.println("Please provide the following information: ");
        System.out.print("Full name: ");
        billingInfo.append(scanner.nextLine());
        System.out.print("Billing Street: ");
        billingInfo.append(scanner.nextLine());
        System.out.print("Billing City: ");
        billingInfo.append(scanner.nextLine());
        System.out.print("Billing State: ");
        billingInfo.append(scanner.nextLine());
        System.out.print("Billing Zip: ");
        shippingInfo.append(scanner.nextLine());
        System.out.print("Shipping Street: ");
        shippingInfo.append(scanner.nextLine());
        System.out.print("Shipping City: ");
        shippingInfo.append(scanner.nextLine());
        System.out.print("Shipping State: ");
        shippingInfo.append(scanner.nextLine());
        System.out.print("Shipping Zip: ");
        shippingInfo.append(scanner.nextLine());

        String fullBillingInfo = billingInfo.toString();
        String fullShippingInfo = shippingInfo.toString();
        System.out.println(fullBillingInfo);
        System.out.println(fullShippingInfo);
    }
}