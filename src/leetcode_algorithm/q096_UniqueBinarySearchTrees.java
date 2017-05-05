package leetcode_algorithm;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * <p>
 * 1         3     3         2      1
 * \        /      /       / \       \
 * 3      2     1      1   3      2
 * /     /        \                      \
 * 2    1         2                       3
 */

public class q096_UniqueBinarySearchTrees {

    public static void main(String[] args) {
        q096_UniqueBinarySearchTrees solution = new q096_UniqueBinarySearchTrees();
        System.out.println(solution.numTrees(2));
        System.out.println(solution.numTrees(3));
        System.out.println(solution.numTrees(4));
        System.out.println(solution.numTrees(19));
    }

    /**
     * 解法1(个人解法)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n == 0) return 0;
        return generateSubtrees(1, n);
    }

    private int generateSubtrees(int s, int e) {
        if (s >= e) return 1;
        int count = 0;
        for (int i = s; i <= e; ++i) {
            int leftCount = generateSubtrees(s, i - 1);
            int rightCount = generateSubtrees(i + 1, e);
            count += leftCount * rightCount;
        }
        return count;
    }


    /**
     * Taking 1~n as root respectively:
     *      1 as root: # of trees = F(0) * F(n-1)  // F(0) == 1
     *      2 as root: # of trees = F(1) * F(n-2)
     *      3 as root: # of trees = F(2) * F(n-3)
     *      ...
     *      n-1 as root: # of trees = F(n-2) * F(1)
     *      n as root:   # of trees = F(n-1) * F(0)
     *
     * So, the formulation is:
     *      F(n) = F(0) * F(n-1) + F(1) * F(n-2) + F(2) * F(n-3) + ... + F(n-2) * F(1) + F(n-1) * F(0)
     */

    /**
     * 解法2(推荐解法)
     *
     * @param n
     * @return
     */
    public int numTrees2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    private final static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
