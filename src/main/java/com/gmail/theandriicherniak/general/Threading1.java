package com.gmail.theandriicherniak.general;

/**
 * Created by andriicherniak on 5/26/16.
 */
public class Threading1 implements Runnable {
    private int counter;
    private static int threadCnt = 1;
    private int threadId = threadCnt++;
    Threading1(int cnt){
       counter = cnt;
    }
    public void run(){
        while (counter > 0){
            System.out.println(threadId + " " + counter);
            Thread.yield();
            counter --;
        }
    }
}
