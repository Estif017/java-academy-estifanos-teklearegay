package com.pluralsight;

public class Pair<T /*extends Musician*/> {
    private T leftthing;
    private T rightThing;

    public Pair(T leftthing, T rightThing) {
        this.leftthing = leftthing;
        this.rightThing = rightThing;
    }

    public void swap(){
        T temp = leftthing;
        leftthing = rightThing;
        rightThing = temp;
    }

    public void perform(){
        // because T Is-A Musician we know that they
        // will have the perform method
//        leftthing.perform();
//        rightThing.perform();
    }

    public T getLeftthing() {
        return leftthing;
    }

    public void setLeftthing(T leftthing) {
        this.leftthing = leftthing;
    }

    public T getRightThing() {
        return rightThing;
    }

    public void setRightThing(T rightThing) {
        this.rightThing = rightThing;
    }
}
