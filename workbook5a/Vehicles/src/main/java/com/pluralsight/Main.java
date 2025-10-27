package com.pluralsight;

public class Main {
    public static void main(String[] args) {
//        Moped slowRide = new Moped();
//        slowRide.setColor("Red");
//        slowRide.setFuelCapacity(5);
        Moped slowRide = new Moped("Red", 5);

        Car car = new Car("Black", 2);

        System.out.println(car.getClass()+" "+car.getColor());

        System.out.println(slowRide.getFuelCapacity());
    }
}
