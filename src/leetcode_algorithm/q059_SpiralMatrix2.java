package leetcode_algorithm;

import java.util.Arrays;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * For example,
 * Given n = 3,
 * <p>
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */

public class q059_SpiralMatrix2 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new q059_SpiralMatrix2().generateMatrix(3)));
    }

    /**
     *  解法1(个人解法)
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = n - 1;
        int colEnd = n - 1;
        int index = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                result[rowBegin][i] = index++;
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                result[i][colEnd] = index++;
            }
            colEnd--;
            for (int i = colEnd; i >= colBegin; i--) {
                result[rowEnd][i] = index++;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowBegin; i--) {
                result[i][colBegin] = index++;
            }
            colBegin++;
        }
        return result;
    }
}
