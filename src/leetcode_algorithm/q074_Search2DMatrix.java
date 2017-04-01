package leetcode_algorithm;


/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */

public class q074_Search2DMatrix {


    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(new q074_Search2DMatrix().searchMatrix(nums, 3));

        nums = new int[][]{
                {1, 3, 5, 7}
        };
        System.out.println(new q074_Search2DMatrix().searchMatrix(nums, 3));
    }

    /**
     * ½â·¨1
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int num = matrix[mid / n][mid % n];
            if (num == target) return true;
            if (num < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
