package com.gmail.theandriicherniak.general;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by andriicherniak on 5/3/16.
 */
public class Main {
    public static void main(String [] args){
        System.out.println("general");

        ExecutorService exec = Executors.newFixedThreadPool(5);
        ArrayList<Future<String>> result = new ArrayList<Future<String>>();

        for (int i = 1; i <= 10; i++) result.add(exec.submit(new Threading2(i)));

        exec.shutdown();

        for (Future<String> fs : result){
            try {
                System.out.println(fs.get());
            }catch (InterruptedException e){
                System.out.println(e);
            }
            catch (ExecutionException e){
                System.out.println(e);
            }
        }

    }
}
