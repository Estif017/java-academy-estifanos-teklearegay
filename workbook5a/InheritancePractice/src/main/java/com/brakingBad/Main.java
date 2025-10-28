package com.brakingBad;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        WalterWhite ww = new WalterWhite();
//        ww.cook();
        ArrayList<Chemist> chemists = new ArrayList<>();
        chemists.add(new WalterWhite());
        chemists.add(new JessePinkman());

        for(Chemist chemist: chemists){
            chemist.cook();
        }
    }
}
