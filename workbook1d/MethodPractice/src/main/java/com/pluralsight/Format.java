package com.pluralsight;

public class Format {
    public static void main(String[] args) {
        String fullName = formatName("Estifanos","Teklearegay");
        System.out.println(fullName);
    }

    public static String formatName(String first, String last){
       return last+" "+first;
    }
}