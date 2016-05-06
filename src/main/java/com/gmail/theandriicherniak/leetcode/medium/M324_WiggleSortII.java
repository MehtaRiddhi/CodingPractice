package com.gmail.theandriicherniak.leetcode.medium;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by andriicherniak on 5/5/16.
 */
public class M324_WiggleSortII {
    Random rnd = new Random(System.currentTimeMillis());

    private void swap(int[] nums, int id1, int id2) {
        int tmp = nums[id1];
        nums[id1] = nums[id2];
        nums[id2] = tmp;
    }

    private int[] arrangeAroundPivot(int[] nums, int from, int to, int pivot) {
        int i = from;
        int j = from;
        int n = to;
        while (j <= n) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] > pivot) {
                swap(nums, j, n);
                n--;
            } else j++;
        }

        int[] result = new int[]{i, i};
        j = i;
        while (j <= n && nums[j] == nums[i]) {
            result[1] = j;
            j++;
        }
        return result;
    }

    public int KthSmallest(int[] nums, int from, int to, int k) {
        if (k < from || k > to) return -1;
        if (to == from) return nums[from];

        int pivotPos = from + rnd.nextInt(to - from + 1);
        int pivot = nums[pivotPos];
        int[] pivotIndexes = arrangeAroundPivot(nums, from, to, pivot);

        if (k >= pivotIndexes[0] && k <= pivotIndexes[1]) return nums[k];
        if (k < pivotIndexes[0]) return KthSmallest(nums, from, pivotIndexes[0] - 1, k);
        else return KthSmallest(nums, pivotIndexes[1] + 1, to, k);
    }

    private int A(int i, int n){
        return (1 + 2 * i)%n;
    }

    public void wiggleSort(int[] nums) {
        int L = nums.length;
        if (L <= 1) return;

        int pivot = KthSmallest(nums, 0, L - 1, L / 2);

    }
}
