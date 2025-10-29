package com.contract;

import com.vehicle.Vehicle;

public class SalesContract extends Contract{
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salesTax = 0.05* vehicleSold.getPrice();
        this.recordingFee = 100;
        this.processingFee= vehicleSold.getPrice()<10000?295:495;
        this.isFinanced = isFinanced;

    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }




    @Override
    public double getTotalPrice(){
        return salesTax+recordingFee+processingFee+ getVehicleSold().getPrice();
    }

    @Override
    public double getMonthlyPayment(){
        if(isFinanced){
            double interestRate;
            int months;

            if(getVehicleSold().getPrice()>10000){
                interestRate=0.0425;
                months=48;
            }else{
                interestRate = 0.0525;
                months = 24;
            }
            double totalWithInterest = getTotalPrice() * (1+interestRate);
            return totalWithInterest/months;
        }else{
            return 0;
        }
    }
}
