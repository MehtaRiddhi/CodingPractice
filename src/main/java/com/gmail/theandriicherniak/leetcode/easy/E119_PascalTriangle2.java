package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/11/16.
 */
import java.util.List;
import java.util.ArrayList;

public class E119_PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row_data = new ArrayList<Integer>(rowIndex);
        if (rowIndex < 0) return row_data;

        row_data.add(1);

        if (rowIndex == 0) return row_data;
        int prev_val = 1;
        double scalor;

        for (int i = 1; i <= rowIndex-1; i ++){
            scalor = 1.0 * (rowIndex + 1 -  i)/i;
            prev_val = (int) Math.round(scalor * prev_val);
            row_data.add(prev_val);
        }
        row_data.add(1);
        return row_data;
    }
}
