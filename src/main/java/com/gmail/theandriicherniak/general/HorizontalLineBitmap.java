package com.gmail.theandriicherniak.general;

/**
 * Created by andriicherniak on 5/4/16.
 */

/**
 * You are given a monochrome bitmap as a byte array (together with its width and height). Draw a horizontal line.
 */
public class HorizontalLineBitmap {
    public void drawLine(byte[] bitmap, int width, int heigth, int y, int x1, int x2){
        int fromBit = width * y + x1;
        int toBit = width * y + x2;
        int maxBit = width * heigth -1 ;
        maxBit = Math.min(maxBit, bitmap.length * 8 - 1);

        for (int pos = Math.min(maxBit, fromBit); pos <= Math.min(maxBit, toBit); pos ++){
            int bitmap_id = pos / 8;
            int element_id = pos % 8;

            bitmap[bitmap_id] |= (1 << element_id) & 0xFF;
        }
    }
}
