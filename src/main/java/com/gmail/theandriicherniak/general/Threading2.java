package com.gmail.theandriicherniak.general;

import java.util.concurrent.Callable;

/**
 * Created by andriicherniak on 5/27/16.
 */
public class Threading2 implements Callable<String> {
    private int id;
    Threading2(int i){
        id = i;
    }
    public String call(){
        return "result " + id;
    }
}
