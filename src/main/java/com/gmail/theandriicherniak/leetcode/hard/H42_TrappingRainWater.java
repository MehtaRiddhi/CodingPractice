package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/29/16.
 */
public class H42_TrappingRainWater {
    public int trap(int[] height) {
        int L = height.length;
        if (L < 3) return 0;
        int volume = 0;

        int [] left_max = new int[L];
        int [] right_max = new int[L];

        left_max[0] = height[0];
        right_max[L-1] = height[L-1];


        for (int i = 1; i < L; i++){
            left_max[i] = Math.max(left_max[i-1], height[i]);
        }
        for (int i = L-2; i >= 0; i--){
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }

        for (int i = 0; i < L; i++){
            volume += Math.max(0, Math.min(right_max[i], left_max[i]) - height[i]);
        }

        return volume;
    }
}
