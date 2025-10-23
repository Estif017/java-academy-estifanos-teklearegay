package com.statics;

public class Main {
    public static void main(String[] args) {
        Saiyan s1 = new Saiyan("Goku",100000);
        Saiyan s2 = new Saiyan("Sonic",3000);
        Saiyan s3 = new Saiyan("Vegta",9999);
        Saiyan s4 = new Saiyan("Mario",10001);
        //static class is not connected to a specefic (individual) sayan
        //but it's a generic method for all sayans
        //It's a class method
        Saiyan.getTotalSayans();
        s1.setPowerlevel(5000);
        s2.setPowerlevel(200);
        s1.showStats();
        Saiyan.showAllSaiyansStats();
        Saiyan.showAllSaiyansStats();
    }
}
