package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/13/16.
 */
import java.util.List;
import java.util.ArrayList;
public class E228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> result = new ArrayList<String>();
        int L = nums.length;
        if (L <= 0) return result;
        if (L == 1) {
            result.add(""+nums[0]);
            return result;
        }
        int p1 = 0;
        int p2 = 0;
        while (p1 < (L - 1)){
            p1++;
            long diff = nums[p1];
            diff -= nums[p1-1];

            if (diff > 1L){
                if ((p1-1) == p2) result.add(""+nums[p2]);
                else result.add(nums[p2]+"->"+nums[p1-1]);
                p2=p1;
            }
        }
        if (p1 == p2) result.add(""+nums[p1]);
        else result.add(nums[p2] + "->" + nums[p1]);
        return result;
    }
}
