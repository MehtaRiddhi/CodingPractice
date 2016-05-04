package com.gmail.theandriicherniak.general;

/**
 * Created by andriicherniak on 5/3/16.
 */

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
model raindrops falling on a sidewalk
 assume you have a piece of sidewalk of length 1 meter,a dn raindrops fall ONLY on that stretch of the sidewalk
 and nowhere else. the width of each raindrop is 1 cm. How many drops will it take to cover that piece of sidewalk
 */

public class ModelRaindrops {
    private class Drop{
        double from;
        double to;
        public Drop(double start, double end){
            from = start;
            to = end;
        }
    }
    public int raindropsNeeded(double sidewalkLength, double raindropLength){
        int cnt = 0;
        if (sidewalkLength < raindropLength) return 0;
        if (sidewalkLength == raindropLength) return 1;
        Random rnd = new Random();
        TreeMap<Double, Drop> t = new TreeMap<Double, Drop>();
        
        double start, end;

        Map.Entry<Double, Drop> pred, succ;
        boolean wet = false;

        while (!wet){
            cnt ++;

            start = (sidewalkLength + raindropLength) * rnd.nextDouble() - raindropLength;
            end = start + raindropLength;
            pred = t.floorEntry(start);

            if (pred != null && pred.getValue().to >= start){
                end = Math.max(pred.getValue().to, end);
                succ = t.ceilingEntry(pred.getValue().to);

                if (succ != null && succ.getKey() <= end){
                    end = Math.max(end, succ.getValue().to);
                    t.remove(succ.getKey());
                }

                t.get(pred.getKey()).to = end;
            }else {
                succ = t.ceilingEntry(start);
                if (succ != null && succ.getKey() <= end) {
                    end = Math.max(end, succ.getValue().to);
                    t.remove(succ.getKey());
                }

                t.put(start, new Drop(start, end));
            }


            if (t.size() == 1) {
                start = Double.MAX_VALUE;
                end = Double.MIN_VALUE;

                for (double key : t.keySet()){
                    start = Math.min(start, key);
                    end = Math.max(end, t.get(key).to);
                    if (start <= 0.0 && end >= 1.0) wet = true;
                }
            }

        }

        return cnt;
    }
}
