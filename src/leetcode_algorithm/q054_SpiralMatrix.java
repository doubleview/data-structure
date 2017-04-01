package leetcode_algorithm;

import java.util.ArrayList;
import java.util.List;

/**

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

        For example,
        Given the following matrix:

        [
            [ 1, 2, 3 ],
            [ 4, 5, 6 ],
            [ 7, 8, 9 ]
        ]

        You should return [1,2,3,6,9,8,7,4,5].
*/

public class q054_SpiralMatrix {

    public static void main(String[] args) {
        System.out.println(new q054_SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new q054_SpiralMatrix().spiralOrder(new int[][]{{0, 1}}));
        System.out.println(new q054_SpiralMatrix().spiralOrder(new int[][]{{0, 1, 2}, {3, 4, 5}}));
        System.out.println(new q054_SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}));
        System.out.println(new q054_SpiralMatrix().spiralOrder(new int[][]{}));
    }


    /**
     * 解法1(个人解法)
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        return getSpiralOrder(new ArrayList<>(), matrix, matrix.length, matrix[0].length, 0, 0);
    }

    private List<Integer> getSpiralOrder(List<Integer> list, int[][] matrix, int row, int col, int r, int c) {
        if (row <= 0 || col <= 0) return list;

        for (int i = c; i < c + col; i++) list.add(matrix[r][i]);

        for (int i = r + 1; i < r + row - 1; i++) list.add(matrix[i][c + col - 1]);

        if (row != 1) {
            List<Integer> columns = new ArrayList<>();
            for (int i = c + col - 1; i >= r; i--) {
                columns.add(matrix[r + row - 1][i]);
            }
            list.addAll(columns);
        }

        if (col != 1) {
            List<Integer> rows = new ArrayList<>();
            for (int i = r + row - 2; i >= r + 1; i--) {
                rows.add(matrix[i][c]);
            }
            list.addAll(rows);
        }

        return getSpiralOrder(list, matrix, row - 2, col - 2, r + 1, c + 1);
    }


    /**
     * 解法2(推荐解法)
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }
}
