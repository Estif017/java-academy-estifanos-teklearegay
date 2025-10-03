package com.pluralsight;
/*
        * Todo App:
        *  A simple console todo application to manage and display your tasks
        ### Features
        - Add a task (title & optional due date)
        -   Wishes:  Assign Importancy / Urgency, Due Data
        -   Reminders
        - Delete a task
        - Show all tasks
          - Organize by day / week * *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Task task = new Task("Learn Java");
        task.markCompleted();
        System.out.println(task);
        Task[] tasks = new Task[3];
        tasks[0]= new Task("Learn the basics of Classes and Methods in Java");
        tasks[1] = new Task("Fill out this Year Up online form. It's feedback for Yearup about how you guys think the lessons are going. https://www.surveymonkey.com/r/VXQF92Q.");
        tasks[2] = new Task("Share your most fun exercise we did in class");
        for (int i = 0; i < tasks.length; i++) {
            tasks[i].markCompleted();
        }
        for (int i = 0; i < tasks.length; i++) {
            System.out.println(tasks[i]);
        }
    }
}