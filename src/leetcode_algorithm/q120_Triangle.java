package leetcode_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

        For example, given the following triangle
        [
        [2],
        [3,4],
        [6,5,7],
        [4,1,8,3]
        ]
        The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

*/

public class q120_Triangle {


    public static void main(String[] args) {
        q120_Triangle solution = new q120_Triangle();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6 , 5 , 7));
        list.add(Arrays.asList(4 , 1 , 8 , 3));
        System.out.println(solution.minimumTotal(list));
    }

    /**
     * ½â·¨1
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2;i>=0;i--)
            for (int j = 0;j <= i;j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }

}
