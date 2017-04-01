package leetcode_algorithm;


import java.util.Arrays;


/**

You are given an n x n 2D matrix representing an image.

        Rotate the image by 90 degrees (clockwise).

        Follow up:
        Could you do this in-place?

*/

public class q048_RotateImage {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new q048_RotateImage().rotate(matrix);
        for (int[] nums : matrix) {
         System.out.println(Arrays.toString(nums));
        }
    }

    /**
     * 解法1 (推荐解法)
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        for(int i = 0; i< matrix.length; i++) {
            for(int j  = i + 1; j < matrix.length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i< matrix.length; i++) {
            for(int j  = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

}
