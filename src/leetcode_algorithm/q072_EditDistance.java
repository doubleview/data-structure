package leetcode_algorithm;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */

public class q072_EditDistance {


    public static void main(String[] args) {
        System.out.println(new q072_EditDistance().minDistance("abc", "edf"));
    }


/*
    Let following be the function definition :-

    f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2

    Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.

    f(i, j) = f(i - 1, j - 1)
    Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper

    f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
    f(i, j - 1) represents insert operation
    f(i - 1, j) represents delete operation
    f(i - 1, j - 1) represents replace operation
    Here, we consider any operation from word1 to word2. It means, when we say insert operation, we insert a new character after word1 that matches the jth character of word2. So, now have to match i characters of word1 to j - 1 characters of word2. Same goes for other 2 operations as well.

    Note that the problem is symmetric. The insert operation in one direction (i.e. from word1 to word2) is same as delete operation in other. So, we could choose any direction.

    Above equations become the recursive definitions for DP.

    Base Case:

    f(0, k) = f(k, 0) = k

    */

    /**
     * 解法1(推荐解法)
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            cost[i][0] = i;
        for (int i = 1; i <= n; i++)
            cost[0][i] = i;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = Math.min(Math.min(a, b), c);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
    }
}
