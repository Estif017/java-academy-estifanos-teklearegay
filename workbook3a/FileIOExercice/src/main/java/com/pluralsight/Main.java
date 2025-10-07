package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
      try{
          //open a file
          FileWriter writer = new FileWriter("skills.txt");

          //write to the file
          writer.write("Skills:\n");
          writer.write("Git, HTML, CSS, Bootstrap\n");
          writer.write(
                  "JavaScript/ES6, jQuery, REST API, Node.js, Express\n");
          writer.write("Angular\n");
          writer.write("Java");
          writer.close();
      }catch (IOException e){
          System.out.println("ERROR: An unexpected error occurred");
          e.printStackTrace();
      }
    }
}