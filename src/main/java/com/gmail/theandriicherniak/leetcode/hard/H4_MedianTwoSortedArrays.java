package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 3/8/16.
 */
public class H4_MedianTwoSortedArrays {
    private int isKthElement(int[] A, int[] B, int La, int Lb, int k, int Apos){
        System.out.println(" k " + k + " Apos " + Apos);
        
        if (Apos > k) return 1;
        int cnt = k - Apos;
        if (cnt == 0) return 0;

        int i = 0;

        while (i < Lb && cnt >= 0){
            if (B[i] < A[Apos]) cnt --;
            i++;
        }

        if (cnt < 0) return -1;

        while (i < Lb && cnt > 0){
            if (B[i] == A[Apos]) cnt --;
            if (cnt == 0) return 0;
            i++;
        }

        if (cnt > 0) return 1;

        return 0;
    }

    private int findKthElement(int[] A, int[] B, int La, int Lb, int k, int from, int to){
        for (int pos = from; pos <= to; pos++){
            System.out.println(pos + " " + A[pos] + " " + isKthElement(A, B, La, Lb, k, pos));
        }
        return 0;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int L1 = nums1.length;
        int L2 = nums2.length;
        if (L1 == 0 && L2 == 0) return 0.0;
        if (L1 != 0 && L2 == 0){
            return 0.5 * (nums1[L1/2] + nums1[L1/2 - (1 - L1 % 2)]);
        }
        if (L1 == 0 && L2 != 0){
            return 0.5 * (nums2[L2/2] + nums2[L2/2 - (1 - L2 % 2)]);
        }

        findKthElement(nums1, nums2, L1, L2, (L1 + L2) / 2, 0, L1 - 1);

        return 0.0;

    }
}
