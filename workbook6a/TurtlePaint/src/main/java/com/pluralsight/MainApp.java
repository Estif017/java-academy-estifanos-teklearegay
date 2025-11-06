package com.pluralsight;

import com.pluralsight.forms.Turtle;
import com.pluralsight.forms.World;
import com.pluralsight.shapes.Circle;
import com.pluralsight.shapes.Shape;
import com.pluralsight.shapes.Square;
import com.pluralsight.shapes.Triangle;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class MainApp
{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {

        /// erere
        //adjusting the canvas
        System.out.print("Enter canvas width: ");
        int width = scanner.nextInt();
        System.out.print("Enter canvas height: ");
        int height = scanner.nextInt();

        //set up the canvas and our turtle
        World world = new World(width,height);
        Turtle turtle = new Turtle(world);

       boolean running = true;

       while(running){
           System.out.println("\n==== Turtle Painter ====");
           System.out.println("1) Add Shape");
           System.out.println("2) Save Image");
           System.out.println("0) Exit");
           System.out.print("Choose: ");
           int choice = scanner.nextInt();

           switch (choice){
               case 1-> addShape(turtle);
               case 2-> world.saveAs("painting.png");
               case 0-> running = false;
               default -> System.out.println("Invalid choice.");
           }
       }
    }

    private static void addShape(Turtle turtle){
        System.out.println("Which shape?");
        System.out.println("1) Square");
        System.out.println("2) Circle");
        System.out.println("3) Triangle");
        System.out.println("4) Random Art Mode");
        System.out.print("Choose: ");
        int shapeChoice = scanner.nextInt();

        System.out.print("Enter border width: ");
        int borderWidth = scanner.nextInt();

        Random random = new Random();

        int x = random.nextInt(200) - 100;
        int y = random.nextInt(200) - 100;
        Point location = new Point(x, y);

        Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

        Shape shape = null;

        switch (shapeChoice){
            case 1 ->{
                System.out.print("Enter side length: ");
                int side = scanner.nextInt();
                shape = new Square(turtle,location,color,borderWidth,side);
            }
            case 2 ->{
                System.out.print("Enter radius: ");
                int radius = scanner.nextInt();
                shape = new Circle(turtle,location,color,borderWidth,radius);
            }
            case 3 ->{
                System.out.print("Enter side length: ");
                int side = scanner.nextInt();
                shape = new Triangle(turtle,location,color,borderWidth,side);
            }
            case 4->{
                for (int i = 0; i < 10; i++) {
                    int shapeType = random.nextInt(3); // 0=square,1=circle,2=triangle
                    int size = random.nextInt(80) + 20;

                    switch (shapeType) {
                        case 0 -> shape = new Square(turtle, new Point(x, y), color, 2, size);
                        case 1 -> shape = new Circle(turtle, new Point(x, y), color, 2, size / 2);
                        default -> shape = new Triangle(turtle, new Point(x, y), color, 2, size);
                    }
                    shape.paint();
                }

            }
            default -> System.out.println("Invalid shape choice.");
        }
        if(shape!=null){
            shape.paint();
            System.out.println("Shape drawn successfully!");
        }
    }
}
