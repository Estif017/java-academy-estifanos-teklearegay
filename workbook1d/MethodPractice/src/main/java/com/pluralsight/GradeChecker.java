package com.pluralsight;

import java.util.Scanner;

public class GradeChecker {
    static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {
        char grade = gradeChaker(scanner);
        System.out.println("Your grade is "+grade);
        scanner.close();
    }

    public static char gradeChaker(Scanner scanner){
        System.out.println("Enter your exam score (0-100)");
        double score = scanner.nextDouble();
        char grade = 'F';
        if(score>90&&score<100){
            grade = 'A';
        }else if(score>80&&score<89){
            grade = 'B';
        }else if(score>70&&score<79){
            grade = 'C';
        }else if(score>60&&score<69){
            grade = 'D';
        }else{
            grade = 'F';
        }
        return grade;
    }
}