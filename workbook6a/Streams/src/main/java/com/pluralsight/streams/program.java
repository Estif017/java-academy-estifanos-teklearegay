package com.pluralsight.streams;

import com.pluralsight.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        people.forEach(person -> System.out.println(person));
        System.out.println("Hello"+
                people.stream().map(person -> person.getAge()).reduce(
                        0,(temp,age)-> temp+=age
                )
        );
        people.stream().map(person ->
                        person.getFirstName().concat(person.getLastName()))
                .sorted().forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a first or last name to search: ");
        String searchName = scanner.nextLine().toLowerCase();
        people.forEach(person -> {if(person.getFirstName().toLowerCase().equals(searchName)||person.getLastName().toLowerCase().equals(searchName)){
            System.out.println(person);}
        });

        int totalAge = people.stream()
                .mapToInt(Person::getAge).sum();
        Person oldestPerson = people.stream()
                .max((p1,p2)->Integer.compare(p1.getAge(), p2.getAge()))
                .orElse(null);
        Person youngestPerson = people.stream()
                .min((p1,p2)->Integer.compare(p1.getAge(), p2.getAge()))
                .orElse(null);

        double averageAge = (double) totalAge / people.size();
        System.out.printf("Average age: %.2f%n", averageAge);
        System.out.println("The youngest person " + youngestPerson);
        System.out.println("The oldest person " + oldestPerson);

        System.out.println("enter a filter word");
        String filterWord = scanner.nextLine();
        List<Person> filteredPeople = people.stream()
                .filter(person -> person.getLastName()
                        .concat(person.getFirstName()).contains(filterWord))
                .collect(Collectors.toUnmodifiableList());
        System.out.println("Result\n"+filteredPeople);

        System.out.println("People above the age of 35");
        System.out.println(people.stream().filter(person -> person.getAge()>30).count());
        people.stream().filter(person -> person.getAge()>30).forEach(System.out::println);

    }
}
