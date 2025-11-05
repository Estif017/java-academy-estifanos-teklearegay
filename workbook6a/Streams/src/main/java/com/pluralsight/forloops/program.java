package com.pluralsight.forloops;

import com.pluralsight.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Garth", "Solis", 25));
        people.add(new Person("Daphne", "Waller", 32));
        people.add(new Person("Vernon", "Meyers", 41));
        people.add(new Person("Kelli", "Russo", 29));
        people.add(new Person("Reba", "Lara", 36));
        people.add(new Person("Bo", "Dodson", 27));
        people.add(new Person("Ronda", "Rodgers", 45));
        people.add(new Person("Johnny", "Whitaker", 31));
        people.add(new Person("Darlene", "Le", 38));
        people.add(new Person("Harrison", "Haney", 23));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a first or last name to search: ");
        String searchName = scanner.nextLine().toLowerCase();

        List<Person> matches = new ArrayList<>();

        for (Person person : people) {
            if (person.getFirstName().toLowerCase().equals(searchName) || person.getLastName().toLowerCase().equals(searchName)) {
                matches.add(person);
            }
        }

        if (matches.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            System.out.println("Matches found:");
            for (Person p : matches) {
                System.out.println(p);
            }
        }

        int totalAge = 0;
        int oldes = people.get(0).getAge();
        Person oldestPerson = people.get(0);
        Person youngestPerson = people.get(0);
        int youngest = people.get(0).getAge();
        for (Person person : people) {
            totalAge += person.getAge();
            if (person.getAge() > oldes) {
                oldes = person.getAge();
                oldestPerson = person;
            }
            if (youngest>person.getAge()) {
                youngest = person.getAge();
                youngestPerson = person;
            }
        }
        double averageAge = (double) totalAge / people.size();
        System.out.printf("Average age: %.2f%n", averageAge);
        System.out.println("Youngers age: " + youngest);
        System.out.println("The youngest person " + youngestPerson);
        System.out.println("oldest age: " + oldes);
        System.out.println("The oldest person " + oldestPerson);
    }
}
