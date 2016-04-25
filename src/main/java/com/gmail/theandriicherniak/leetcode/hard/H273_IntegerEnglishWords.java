package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/24/16.
 */
public class H273_IntegerEnglishWords {
    private String N0_19_string(int n){
        String result = "";
        switch (n) {
            case 0 : result = "Zero"; break;
            case 1 : result = "One"; break;
            case 2 : result = "Two"; break;
            case 3 : result = "Three"; break;
            case 4 : result = "Four"; break;
            case 5 : result = "Five"; break;
            case 6 : result = "Six"; break;
            case 7 : result = "Seven"; break;
            case 8 : result = "Eight"; break;
            case 9 : result = "Nine"; break;
            case 10 : result = "Ten"; break;
            case 11 : result = "Eleven"; break;
            case 12 : result = "Twelve"; break;
            case 13 : result = "Thirteen"; break;
            case 14 : result = "Fourteen"; break;
            case 15 : result = "Fifteen"; break;
            case 16 : result = "Sixteen"; break;
            case 17 : result = "Seventeen"; break;
            case 18 : result = "Eighteen"; break;
            case 19 : result = "Nineteen"; break;
        }
        return result;
    }
    private String N20_90(int n){
        String result = "";
        switch (n){
            case 2 : result = "Twenty"; break;
            case 3 : result = "Thirty"; break;
            case 4 : result = "Forty"; break;
            case 5 : result = "Fifty"; break;
            case 6 : result = "Sixty"; break;
            case 7 : result = "Seventy"; break;
            case 8 : result = "Eighty"; break;
            case 9 : result = "Ninety"; break;
        }
        return result;
    }

    private String ThreeDNumber(int n, boolean showZero){
        StringBuilder sb = new StringBuilder();
        int hundreds = n / 100;
        int tens = 0;
        int rest = n - 100 * hundreds;
        if (rest >= 20) {
            tens = rest / 10;
            rest = rest - 10 * tens;
        }

        if (hundreds > 0) sb.append(" " + N0_19_string(hundreds) + " Hundred");
        if (tens > 0) sb.append(" " + N20_90(tens));
        if (rest > 0 || (showZero && hundreds == 0 && tens == 0)) sb.append(" " + N0_19_string(rest));
        return sb.toString().trim();
    }
    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        int billions = num / 1000000000;
        int millions = (num - 1000000000 * billions) / 1000000;
        int thousands = (num - 1000000000 * billions - 1000000 * millions)/1000;
        int rest = num - 1000000000 * billions - 1000000 * millions - 1000 * thousands;

        if (billions > 0) sb.append(" " + ThreeDNumber(billions, false) + " Billion");
        if (millions > 0) sb.append(" " + ThreeDNumber(millions, false) + " Million");
        if (thousands > 0) sb.append(" " + ThreeDNumber(thousands, false) + " Thousand");

        sb.append(" " + ThreeDNumber(rest, billions == 0 && millions == 0 && thousands == 0));

        return sb.toString().trim();
    }
}
