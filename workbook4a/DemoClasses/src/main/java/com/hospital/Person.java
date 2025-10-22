package com.hospital;

public class Person {

    public String name;
    public String jobtitle;

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        if(jobtitle == "Student")
        {
            System.out.println("is not allowed to operate");
        }
        this.jobtitle = jobtitle;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
