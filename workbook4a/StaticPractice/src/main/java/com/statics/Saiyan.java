package com.statics;

import java.util.ArrayList;

public class Saiyan {

    //instance variables unique for any saiyans
    private String name;
    private  int powerlevel;
    static ArrayList<Saiyan> allSayans = new ArrayList<>();

    //static variables - shared by ALL Saiyans
    static private  int totalSayans = 0;

    public Saiyan(String name, int powerlevel){
        this.name = name;
        this.powerlevel = powerlevel;
        totalSayans++; // One extra saiyan has been created
        allSayans.add(this);
    }

    public void setPowerlevel(int powerlevel) {
        if(powerlevel>0){
            this.powerlevel = powerlevel;
        }
    }

    public static void getTotalSayans() {
        System.out.println(totalSayans);
    }
    public static void showAllSaiyansStats() {
        for(Saiyan s : allSayans)
        {
            s.showStats();
        }

    }
    //Show stats of Goku
    public void showStats() {
        //non-static is values that belongs to the object
        // static measn generic information not a particilar saiyan or object.

        System.out.println("Name: " + this.name);
        System.out.println("Powerlevel: " + this.powerlevel);
    }
}
