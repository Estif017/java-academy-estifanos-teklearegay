package com.hotel.employee;

import java.time.LocalTime;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay(){
        double regulaPay = getRegulaHours()*payRate;
        double overTimePay = this.hoursWorked>40 ? getOverTimeHours()*((payRate/2)+payRate) : 0;
        return regulaPay+overTimePay;
    }

    public double getRegulaHours(){
       return this.hoursWorked>40 ? 40 : this.hoursWorked;
    }

    public double getOverTimeHours(){
        return this.hoursWorked>40 ? this.hoursWorked - 40 : 0;
    }

//    public void punchTimeCard(double timeIn, double timeOut){
//        double timeWorked = timeOut-timeIn;
//        this.setHoursWorked(this.getHoursWorked()+timeWorked);
//    }

    public double punchIn(double time){
        return time;
    }

    public void punchOut(double time){
        this.setHoursWorked(this.getHoursWorked()+(time-this.punchIn(time)));
    }

    public LocalTime punchIn(){
        return LocalTime.now();
    }

    public void punchOut(){
        double punchintieme = Double.parseDouble(String.valueOf(this.punchIn()));
        double punchoutTIme = Double.parseDouble(String.valueOf(LocalTime.now()));
        this.setHoursWorked((this.getHoursWorked()+Double.parseDouble(String.valueOf(punchoutTIme-punchintieme))));
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
