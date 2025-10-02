package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int num1 = 91;
        int num2 = 99;
        int product = num1*num2;
        //todo: check if the product give us a palindrom number
//             how? first we will change the prduct to string
//                then we reverse the stringproduct
//                  then we match it
        String strProduct = String.valueOf(product);
        String revStrProduct = "";
        for(int i = strProduct.length()-1;i>=0;i--){
            revStrProduct +=strProduct.charAt(i);
        }
        System.out.println(strProduct.equals(revStrProduct));

        //
    }
}