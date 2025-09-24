package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        * favoriteColor
favoriteArtist
Did you eat already?
your age*/
        String favoriteColor = "blue";
        String favoriteArtist = "the weekend";
        boolean breakfast = false; boolean isHappy = true;
        String firstName = "Estifanos";
        String lastName = "Teklearegay";
        String fullName = firstName + " "+ lastName;
        System.out.println(fullName);
        System.out.println(favoriteColor);
        System.out.println(favoriteArtist);
        System.out.println(breakfast);
        favoriteColor = "Red";
        System.out.println(favoriteColor);

        if(isHappy && breakfast){
            System.out.println("Nice Job!");
        } else if (isHappy && !breakfast) {
            System.out.println("You could be hungry.");
        }else{
            System.out.println("Do some thing about it!");
        }
    }
}