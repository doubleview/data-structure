package leetcode_algorithm;
/**
 *

Given a string s, partition s such that every substring of the partition is a palindrome.

        Return the minimum cuts needed for a palindrome partitioning of s.

        For example, given s = "aab",
        Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

*/

public class q132_PalindromePartitioning2 {


    public static void main(String[] args) {
        q132_PalindromePartitioning2 solution = new q132_PalindromePartitioning2();
        System.out.println(solution.minCut("aab"));
        System.out.println(solution.minCut("aabb"));
    }

    /**
     * ½â·¨1
     * @param s
     * @return
     */
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0;i<n ;i++) {
            int min = i;
            for(int j = 0;j<=i;j++) {
                if (c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j==0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }

}
