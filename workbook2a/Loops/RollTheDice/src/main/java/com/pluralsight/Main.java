package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice();
        int roll1;
        int roll2;
        int number2counter= 0;
        int number4counter=0;
        int number6counter=0;
        int number7counter=0;
        for (int i=0;i<100;i++){
            roll1=dice.roll();
            roll2=dice.roll();
            int sum = Integer.sum(roll1,roll2);
            System.out.println("Roll "+i+": "+roll1+" - "+roll2+" Sum: "+sum);
            if(sum==2){
                number2counter++;
            } else if (sum==4) {
                number4counter++;
            } else if (sum==6) {
                number6counter++;
            } else if (sum==7) {
                number7counter++;
            }
        }
        System.out.println("Number 2 show up "+number2counter+" times!");
        System.out.println("Number 4 show up "+number4counter+" times!");
        System.out.println("Number 6 show up "+number6counter+" times!");
        System.out.println("Number 7 show up "+number7counter+" times!");
    }
}