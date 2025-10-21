package com.hotel;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public boolean isAvailable(){
      return !isOccupied && !isDirty;
    }

    public void checkIn(){
        if(isAvailable()){
            this.setOccupied(true);
            this.setDirty(false);
        }
    }

    public void checkOut(){
        this.setOccupied(false);
        this.cleanroom();
    }

    public void cleanroom(){
        if(!this.isOccupied()){
            this.setDirty(false);
        }
    }


    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    @Override
    public String toString() {
        return "Room{" +
                "numberOfBeds=" + numberOfBeds +
                ", price=" + price +
                ", isOccupied=" + isOccupied +
                ", isDirty=" + isDirty +
                ", isAvailable=" + this.isAvailable() +
                '}';
    }
}
