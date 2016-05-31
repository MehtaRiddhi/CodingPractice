package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/11/16.
 */
import java.util.ArrayList;
import java.util.List;

public class E118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triange = new ArrayList<List<Integer>>();
        if (numRows < 1) return triange;

        ArrayList<Integer> row1 = new ArrayList<Integer>(1);
        row1.add(1);
        triange.add(row1);

        if (numRows == 1) return triange;

        ArrayList<Integer> row2 = new ArrayList<Integer>(2);
        row2.add(1);
        row2.add(1);
        triange.add(row2);

        if (numRows == 2) return triange;


        for (int row = 3; row <= numRows; row ++){
            ArrayList<Integer> row_data = new ArrayList<Integer>(row);
            row_data.add(1);
            for (int i = 1; i <= row - 2; i++){
                row_data.add(triange.get(row-2).get(i-1) + triange.get(row-2).get(i));
            }
            row_data.add(1);

            triange.add(row_data);
        }
        return triange;
    }
}
