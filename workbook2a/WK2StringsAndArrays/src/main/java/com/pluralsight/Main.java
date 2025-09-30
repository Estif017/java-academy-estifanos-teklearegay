package com.pluralsight;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
//        for (int i = 1;i<=10;i++){
//            System.out.println(i+ "I will be a good developer!");
//        }
//        for(int i = 81;0<i; i--){
//            System.out.println(i+" more days left of Year Up Code academy");
//        }
        System.out.println("For Loop: Counting from 1 to 5");
        for (int i = 1; i <= 5; i++) {
            if(i%2==0){
                System.out.println("Iteration " + i);
            }
        }
        System.out.println("type Exit");

        String input= scanner.nextLine();

        do{
            System.out.println("Type \"Exit\" to terminate the code ");
        }while(!input.equals("Exit"));{
            System.out.println("Seriously type Exit");
            input = scanner.nextLine();
            System.out.println("The code run forever unless you type \"Exit\"");
        }
        int j = 60;
        while (j > 0) {
            System.out.println("Countdown: " + j);
            Thread.sleep(1000);
            j--;
        }

    }
}