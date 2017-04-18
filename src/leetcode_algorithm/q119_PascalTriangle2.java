package leetcode_algorithm;

import java.util.ArrayList;
import java.util.List;

/**

Given an index k, return the kth row of the Pascal's triangle.

        For example, given k = 3,
        Return [1,3,3,1].

        Note:
        Could you optimize your algorithm to use only O(k) extra space?

*/

public class q119_PascalTriangle2 {

    public static void main(String[] args) {
        q119_PascalTriangle2 solution = new q119_PascalTriangle2();
        System.out.println(solution.getRow(3));
    }

    /**
     * ½â·¨1
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<rowIndex+1;i++) {
            res.add(1);
            for(int j =i-1;j>0;j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }


}
