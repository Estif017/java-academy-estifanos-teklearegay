package com.pluralsight;

import java.util.Arrays;
import java.util.OptionalInt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] testScore = {67, 98, 90, 65, 77, 88, 76, 59, 67, 99};
        int max = 0;
        int low = testScore[0];
        int sum = 0;
        for (int i = 0; i < testScore.length; i++) {
            sum = sum + testScore[i];
            if (max < testScore[i]) {
                max = testScore[i];
            }
            if (low > testScore[i]) {
                low = testScore[i];
            }
        }
        System.out.println("Max = " + max + " Min = " + low + " Ave = " + sum / 10 + " Midean = " + (testScore[4] + testScore[5] / 2));
        CodeWars cw = new CodeWars("Learning", "take a moment");
        System.out.println(cw.toString());
    }
}