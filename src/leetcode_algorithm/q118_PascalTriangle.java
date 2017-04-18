package leetcode_algorithm;


import java.util.ArrayList;
import java.util.List;

/**

Given numRows, generate the first numRows of Pascal's triangle.

        For example, given numRows = 5,
        Return

        [
        [1],
        [1,1],
        [1,2,1],
        [1,3,3,1],
        [1,4,6,4,1]
        ]
*/

public class q118_PascalTriangle {

    public static void main(String[] args) {
        q118_PascalTriangle solution = new q118_PascalTriangle();
        System.out.println(solution.generate(5));
    }
    /**
     * 解法1(个人解法)
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<numRows;i++) {
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0;j<i+1;j++) {
                if(j==0 || j==i) {
                    tmp.add(1);
                }else {
                    tmp.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                }
            }
            result.add(tmp);
        }
        return result;
    }

}
