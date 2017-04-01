package leetcode_algorithm;

/**
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 */

public class q063_UniquePaths2 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(new q063_UniquePaths2().uniquePathsWithObstacles(nums));
        nums = new int[][]{{0, 1}};
        System.out.println(new q063_UniquePaths2().uniquePathsWithObstacles(nums));
        nums = new int[][]{
                {0, 0},
                {1, 1},
                {0, 0}
        };
        System.out.println(new q063_UniquePaths2().uniquePathsWithObstacles(nums));
    }


    /**
     *  解法1(个人解法)
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;
                } else {
                    int left = (j - 1 >= 0) ? obstacleGrid[i][j - 1] : 0;
                    int up = (i - 1 >= 0) ? obstacleGrid[i - 1][j] : 0;
                    obstacleGrid[i][j] = left + up;
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
