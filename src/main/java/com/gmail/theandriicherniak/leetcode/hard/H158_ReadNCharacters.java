package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/27/16.
 */
public class H158_ReadNCharacters {
    int bufLen;
    int buf4Len = 0;
    int buf4pos = 0;
    boolean buf4end = false;
    char [] buf4 = new char[4];

    int read4(char[] buf){
        return 4;
    }
    public int read(char[] buf, int n) {
        bufLen = 0;
        for (int i = 0; i < n; i++){
            if (buf4Len == 0 || buf4pos == buf4Len){
                if (!buf4end) {
                    buf4pos = 0;
                    buf4Len = read4(buf4);
                    if (buf4Len < 4) buf4end = true;
                    if (buf4Len == 0) return bufLen;
                }else return bufLen;
            }
            buf[bufLen] = buf4[buf4pos];
            bufLen ++;
            buf4pos ++;
        }
        return n;
    }
}
