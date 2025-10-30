package com.pluralsight;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;

    // Constructor
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    // toString for easy printing
    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }

    /**
     * Implement the compareTo() method from Comparable<Person>.
     * Sort by last name first, then first name, then age.
     */
    @Override
    public int compareTo(Person other) {
        // First, compare by last name
        int lastNameCompare = this.lastName.compareToIgnoreCase(other.lastName);
        if (lastNameCompare != 0) {
            return lastNameCompare;
        }

        // If last names are equal, compare by first name
        int firstNameCompare = this.firstName.compareToIgnoreCase(other.firstName);
        if (firstNameCompare != 0) {
            return firstNameCompare;
        }

        // If both names are equal, compare by age
        return Integer.compare(this.age, other.age);
    }
}
