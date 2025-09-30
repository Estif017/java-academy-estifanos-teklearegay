package com.pluralsight;

import java.util.Arrays;
import java.util.Scanner;

public class FullNameParser {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please enter your full name: first and last or first middle last");
        String fullName = scanner.nextLine();
        String[] nameParts = fullName.split(" ");
        int nameLength = fullName.split(" ").length;
        for(int i=0;i<nameLength;i++){
            if(i==0){
                System.out.println("First name: "+nameParts[i]);
            } else if (i==1 && nameLength==2) {
                System.out.println("Middle name: (none)");
                System.out.println("Last name: "+nameParts[i]);
            }else if(i==1 && nameLength==3) {
                System.out.println("Middle name: "+nameParts[i]);
            } else if (i==2) {
                System.out.println("Last name: "+nameParts[i]);

            }
        }
    }
}