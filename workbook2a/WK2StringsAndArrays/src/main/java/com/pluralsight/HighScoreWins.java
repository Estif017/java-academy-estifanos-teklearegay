package com.pluralsight;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HighScoreWins {
   static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please enter a game score:");
        String scoreline = scanner.nextLine();
        String[] st =scoreline.split(":");
        String[] st1 = st[1].split(Pattern.quote("|"));
        if(Integer.parseInt(st[2])<Integer.parseInt(st1[1])){
            System.out.println("Winner: "+st[0]);
        }else{
            System.out.println("Winner: "+st1[0]);
        }
    }
}