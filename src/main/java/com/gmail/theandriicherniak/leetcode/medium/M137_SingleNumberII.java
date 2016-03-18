package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/18/16.
 */
public class M137_SingleNumberII {

    public int singleNumber(int[] nums) {
        int L = nums.length;
        if (L == 0) return 0;
        if (L == 1) return nums[0];
        int[] counter = new int[32];
        int bitMap;
        int shift;
        int vAbs;

        for (int v : nums) {
            bitMap = 1;
            shift = 0;
            if (v < 0) counter[31] = (counter[31] + 1) % 3;
            vAbs = Math.abs(v);

            while (bitMap <= vAbs && shift <= 30) {
                if ((vAbs & bitMap) != 0) counter[shift] = (counter[shift] + 1) % 3;
                bitMap <<= 1;
                shift ++;
            }
        }

        int result = 0;
        for (int i = 30; i >= 0; i--) {
            result <<= 1;
            result += counter[i];
        }

        if (counter[31] == 1 && result > 0) result *= -1;
        if (counter[31] == 1 && result == 0) result = 1 << 31;


        return result;
    }
}
