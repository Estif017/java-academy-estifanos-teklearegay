package com.pluralsight;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> myFamily = new ArrayList<>();

        myFamily.add(new Person("Dana", "Wyatt", 63));
        myFamily.add(new Person("Zachary", "Westly", 31));
        myFamily.add(new Person("Elisha", "Aslan", 14));
        myFamily.add(new Person("Ian", "Auston", 16));
        myFamily.add(new Person("Zephaniah", "Hughes", 9));
        myFamily.add(new Person("Ezra", "Aiden", 17));

        System.out.println("Before sorting:");
        for (Person p : myFamily) {
            System.out.println(p);
        }

        // Sort using the built-in Collections.sort()
        Collections.sort(myFamily);

        System.out.println("\nAfter sorting:");
        for (Person p : myFamily) {
            System.out.println(p);
        }
    }
}
