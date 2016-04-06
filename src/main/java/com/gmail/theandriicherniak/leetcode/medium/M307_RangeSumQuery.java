package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/6/16.
 */
public class M307_RangeSumQuery {
    private int [] tree;
    private int treeL;

    private int [] data;

    private void addV(int i, int v){
        while (i < treeL) {
            tree[i] += v;
            i += i & (-i);
        }
    }

    private int getV(int i){
        int result = 0;
        while (i > 0){
            result += tree[i];
            i -= i & (-i);
        }
        return result;
    }

    public M307_RangeSumQuery(int[] nums) {
        data = nums;

        int L = nums.length;
        tree = new int[L + 1];
        treeL = L + 1;

        for (int i = 0; i < L; i++){
            addV(i + 1, nums[i]);
        }
    }

    void update(int i, int val) {
        addV(i + 1, -data[i]);
        addV(i + 1, val);
        data[i] = val;
    }

    public int sumRange(int i, int j) {
        int counter = 0;
        if (j - i <= 4){
            for (int k = i; k <= j; k++) counter += data[k];
        }else{
            int s1 = getV(i + 1);
            int s2 = getV(j + 1);
            counter = s2 - s1 + data[i];
        }
        return counter;
    }
}
