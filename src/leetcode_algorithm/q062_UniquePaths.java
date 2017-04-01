package leetcode_algorithm;

/**

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

        The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

        How many possible unique paths are there?

*/

public class q062_UniquePaths {

    public static void main(String[] args) {
        System.out.println(new q062_UniquePaths().uniquePaths(2, 2));
        System.out.println(new q062_UniquePaths().uniquePaths(2, 3));
        System.out.println(new q062_UniquePaths().uniquePaths(3, 7));
        System.out.println(new q062_UniquePaths().uniquePaths(23, 12));
    }

    /**
     *  解法1(个人解法)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        return unique(m , n , 1 , 1 );
    }

    private int unique(int m, int n, int x, int y) {
        if (x == m || y == n) {
            return 1;
        }
        int result = 2 * unique(m, n, x + 1, y + 1);
        if (x + 2 <= m) {
            result += unique(m, n, x + 2, y);
        }
        if (y + 2 <= n) {
            result += unique(m, n, x, y + 2);
        }
        return result;
    }

    /**
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i = 0; i<m;i++) {
            for(int j = 0;j < n;j++) {
                if(i == 0 || j == 0)
                    grid[i][j] = 1;
                else grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }
        return grid[m - 1][n - 1];
    }

}
