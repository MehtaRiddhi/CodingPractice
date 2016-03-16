package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 3/8/16.
 */
public class H4_MedianTwoSortedArrays {
    private double medianSingleArray(int [] nums, int L){
        int medId1 = L / 2;
        int medId2 = (L % 2 == 1) ? L / 2 : (L / 2 - 1);
        return 0.5 * (nums[medId1] + nums[medId2]);
    }

    private boolean leStats(int [] nums, int L, int v, int leOrder){
        if (leOrder > L) return false;
        if (leOrder == 0) {
            if (nums[0] >= v) return true;
            return false;
        }
        if (leOrder == L){
            if (nums[L - 1] <= v) return true;
            return false;
        }
        if (nums[leOrder - 1] <= v && v <= nums[leOrder]) return true;
        return false;
    }
    private int getKthElement(int[] nums1, int[] nums2, int L1, int L2, int K){
        for (int i = 0; i < Math.min(K, L1); i++){
            int residualK = K - i - 1;
            boolean satisfiedConstraint = leStats(nums2, L2, nums1[i], residualK);
            if (satisfiedConstraint) return nums1[i];
        }

        for (int i = 0; i < Math.min(K, L2); i++){
            int residualK = K - i - 1;
            boolean satisfiedConstraint = leStats(nums1, L1, nums2[i], residualK);
            if (satisfiedConstraint) return nums2[i];
        }

        return nums1[0];
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int L1 = nums1.length;
        int L2 = nums2.length;

        if (L1 == 0 && L2 == 0) return 0;
        if (L1 == 0 && L2 > 0) return medianSingleArray(nums2, L2);
        if (L1 > 0 && L2 == 0) return medianSingleArray(nums1, L1);

        int L3 = L1 + L2;
        int medId1 = L3 / 2;
        int medId2 = (L3 % 2 == 1) ? L3 / 2 : (L3 / 2 - 1);

        if (L3 % 2 == 1) return getKthElement(nums1, nums2, L1, L2, medId1 + 1);

        int m1 = getKthElement(nums1, nums2, L1, L2, medId1 + 1);
        int m2 = getKthElement(nums1, nums2, L1, L2, medId2 + 1);


        return 0.5 * (m1 + m2);
    }
}
