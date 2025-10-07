package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(int _employeeId,double _hoursWorked, double _payRate){
        this.employeeId = _employeeId;
        this.hoursWorked = _hoursWorked;
        this.payRate = _payRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getGrossPay(){
        return this.hoursWorked*this.payRate;
    }
}
