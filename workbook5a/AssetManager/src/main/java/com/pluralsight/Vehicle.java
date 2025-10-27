package com.pluralsight;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getValue(){
        double value = 0;
        if(year>0 && year<3){
            value=getOriginalCost()-(getOriginalCost()*0.03);
        }else if(year>4 && year<6){
            value=getOriginalCost()-(getOriginalCost()*0.06);
        }else if(year>7 && year<10){
            value=getOriginalCost()-(getOriginalCost()*0.08);
        }else if(year>10){
            value=getOriginalCost()-1000;
        }
        if(odometer >100000 && !(makeModel.contains("Toyota")||makeModel.contains("Honda"))){
            value = value*0.75; // reduce by 25%
        }
        return value;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "makeModel='" + makeModel + '\'' +
                ", year=" + year +
                ", odometer=" + odometer +
                '}';
    }
}
