package leetcode_algorithm;


/**

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

        Note: You can only move either down or right at any point in time.
*/

public class q064_MinmunPathSum {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(new q064_MinmunPathSum().minPathSum(nums));
        nums = new int[][]{
                {1 , 2},
                {1,  1}
        };
        System.out.println(new q064_MinmunPathSum().minPathSum(nums));
    }

    /**
     *  解法1(个人解法)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(i==0 && j ==0)continue;
                int left = (j -1<0) ? Integer.MAX_VALUE : grid[i][j - 1];
                int up = (i - 1 < 0) ? Integer.MAX_VALUE : grid[i - 1][j];
                grid[i][j] = Math.min(left, up) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }


}
