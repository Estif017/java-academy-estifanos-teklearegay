package com.pluralsight;

import java.util.Scanner;

public class StringsPractice {
    public static void main(String[] args) {
        Boolean isThisValid = ValidateEmailAdres("rmailjard@sasa.org");

        ValidateEmailAdres("rmailjard@yEARup.OrG");
        ValidateEmailAdres("rmailjard@yxxxxxRup.OrG");
        ValidateEmailAdres("rmailjard@yxxxxxRup.OrG");
        ValidateEmailAdres("rmailjard@yxxxxxRup.OrG");
        ValidateEmailAdres("rmailjard@yxxxxxRup.OrG");

        LogginChecker();


    }

    private static void LogginChecker() {

        Scanner read = new Scanner(System.in);

        System.out.println("What is your password");
        String password = read.nextLine();
        String correctPassword = "1234";
        if(password.equals(correctPassword))
        {
            System.out.println("That is correct, you are logged in");
        }
        else
        {
            System.out.println("That is incorrect, try again");
        }

    }

    public static Boolean ValidateEmailAdres(String mail) {

        boolean isValid;
        String lowercased = mail.toLowerCase();
        int AtPosition = lowercased.indexOf("@");//9
        String extraction = lowercased.substring(AtPosition + 1);//cuts the text between 0 and 9
        System.out.println(extraction);

        if (extraction.equals("yearup.org")) {
            isValid = true;
        }
        else
        {
            isValid = false;
        }
        return isValid;

    }
}