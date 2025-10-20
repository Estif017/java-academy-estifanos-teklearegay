package com.hotel;

public class Reservation {
//    private double king = 139.00;
//    private double _double = 124.00;
    private String roomType;
    private Double price;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;

        if(this.roomType.toLowerCase().equalsIgnoreCase("king")) this.setPrice(139.00);
        else if (this.roomType.toLowerCase().equalsIgnoreCase("king")) this.setPrice(124.00);
        else this.setPrice(124.00);

        if(isWeekend) this.setPrice((this.price*0.1)+this.price);
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }
}
