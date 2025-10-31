package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        //Using pair as intiger
        Pair<Integer> twoNums = new Pair<>(23,21);
        System.out.println("Before swap");
        System.out.println(twoNums.getLeftthing()+", "+ twoNums.getRightThing());
        twoNums.swap();
        System.out.println("After swap");
        System.out.println(twoNums.getLeftthing()+", "+ twoNums.getRightThing());

        //Using Pair as String
        Pair<String> twoString = new Pair<>("Me","You");
        System.out.println("Before swap");
        System.out.println(twoString.getLeftthing()+" n "+ twoString.getRightThing());
        twoString.swap();
        System.out.println("After swap");
        System.out.println(twoString.getLeftthing()+" n "+ twoString.getRightThing());
    }
}
