package com.pluralsight;

public class Pair<T> {
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
