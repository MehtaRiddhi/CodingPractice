package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 4/27/16.
 */
public class E157_ReadNCharacters {
    int read4(char[] buf){
        return 4;
    }
    public int read(char[] buf, int n) {
        int bufLen = 0;
        boolean toContinue = true;
        int got4;
        char [] buf4 = new char[4];
        int id;

        while (toContinue){
            got4 = read4(buf4);
            if (got4 < 4) toContinue = false;
            id = 0;

            while (id < got4 && bufLen < n){
                buf[bufLen] = buf4[id];
                bufLen ++;
                id ++;
            }
            if (bufLen >= n) toContinue = false;
        }
        return bufLen;
    }
}
