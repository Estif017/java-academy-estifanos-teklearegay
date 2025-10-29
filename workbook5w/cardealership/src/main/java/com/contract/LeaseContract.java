package com.contract;

import com.vehicle.Vehicle;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice()*0.5;
        this.leaseFee = (expectedEndingValue*0.07);
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice(){
        return expectedEndingValue+leaseFee;
    }

    @Override
    public double getMonthlyPayment(){
        return ((getTotalPrice()*0.04)+getTotalPrice())/36;
    }
}
