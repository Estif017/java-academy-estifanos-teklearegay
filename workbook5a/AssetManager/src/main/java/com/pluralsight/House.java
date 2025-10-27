package com.pluralsight;

public class House extends Asset{
    private String address;
    private int condition;//(1 -excellent, 2 -good, 3 -fair, 4 -poor)
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, String adress, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = adress;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public double getValue(){
        double value = 0;
        if(this.condition==1){
            value=180*squareFoot;
        } else if (this.condition==2) {
            value=130*squareFoot;
        } else if (this.condition==3) {
            value=90*squareFoot;
        }
        else if (this.condition==4) {
            value=80*squareFoot;
        }
        value+=0.25*lotSize;
        return value;
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", condition=" + condition +
                ", squareFoot=" + squareFoot +
                ", lotSize=" + lotSize +
                '}';
    }
}
