package com.gmail.theandriicherniak.general;

/**
 * Created by andriicherniak on 5/3/16.
 */
public class Main {
    public static void main(String [] args){
        System.out.println("general");

        byte [] bitmap = new byte[40];


        HorizontalLineBitmap line = new HorizontalLineBitmap();
        line.drawLine(bitmap, 32, 10, 3, 5, 20);
        for (byte v : bitmap){
            System.out.println(v);
        }
    }
}
