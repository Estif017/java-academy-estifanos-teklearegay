package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i <= 10; i++) {
//            if (i % 3 == 0) {
//                continue;
//            }
            if (i % 3 != 0) { // no need for continue
                sum += i;
            }
//            sum += i;
            System.out.println(sum);
        }
        System.out.println("Sum = " + sum);
        
    }
}