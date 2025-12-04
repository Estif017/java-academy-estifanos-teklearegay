package com.pluralsight.shapes;

import com.pluralsight.forms.Turtle;

import java.awt.*;

public class Circle extends Shape{
    private int radius;

    public Circle(Turtle turtle, Point location, Color color, int borderWidth, int radius) {
        super(turtle, location, color, borderWidth);
        this.radius = radius;
    }

    @Override
    public void paint() {
        turtle.penUp();
        turtle.goTo(location.x, location.y - radius);
        turtle.setColor(color);
        turtle.setPenWidth(borderWidth);
        turtle.penDown();

        // Approximate a circle using 360 tiny lines
        int steps = 60; // fewer = faster, smoother animation
        for (int i = 0; i < steps; i++) {
            turtle.forward((5 * Math.PI * radius) / steps);
            turtle.turnRight(360.0 / steps);
        }


        turtle.penUp();
    }
}
