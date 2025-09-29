package com.pluralsight;

import java.util.Scanner;

public class PassingVariables{
    public static void main(String[] args) {
        introductory("Estifanos",25);
    }
    public static void introductory(String name, int age){
        System.out.println("Hi my name is "+name+" and I'm "+age+" and I have "+(62-age)+" years to retire");
    }

}
