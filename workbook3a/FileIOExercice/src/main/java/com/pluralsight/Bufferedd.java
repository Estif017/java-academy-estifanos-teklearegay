package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Bufferedd {
    public static void main(String[] args) {
        try{
            //create a file writer
            FileWriter writer = new FileWriter("src/text.txt");

            //create Buffered writer
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            //write to the file
            String text;
            for(int i=0; i<=10;i++){
                text = String.format("Counting %d\n",i);
                bufferedWriter.write(text);
            }


            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("ERROR: An unexpected error occurred");
            e.getStackTrace();
        }
    }
}
