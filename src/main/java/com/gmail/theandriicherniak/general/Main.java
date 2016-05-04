package com.gmail.theandriicherniak.general;

/**
 * Created by andriicherniak on 5/3/16.
 */
public class Main {
    public static void main(String [] args){
        System.out.println("general");

        ModelRaindrops drops = new ModelRaindrops();
        System.out.println(drops.raindropsNeeded(1.0, 0.01));
    }
}
