package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;

public class Task {
    //Instance variable, a variable linked to one version of
    private String title;
    private LocalDate duedate;
    private boolean complete;
    private String urgency; // (A list of default values => ENUM)
    private String NotificationMessage;
    private boolean Reminder;

    Scanner scanner = new Scanner(System.in);

    public Task(String _title){
        System.out.println("Enter your task");
        this.title = _title;
    }

    public void markCompleted(){
        this.complete=true;
    }

    @Override
    public String toString() {
        if (this.complete) {
            return "[✓] " + title;
        } else {
            return "[ ] " + title;
        }
    }

    public void AdvancedSetting(){
        System.out.println("Add a urgency ");
        System.out.println("press H for High priority, M moderate and L for low priority");

    }
}
