package leetcode_algorithm;
/**
Given a binary tree, find the maximum path sum.

        For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

        For example:
        Given the below binary tree,

        1
        / \
        2   3
        Return 6.
*/

public class q124_BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        q124_BinaryTreeMaximumPathSum solution = new q124_BinaryTreeMaximumPathSum();
        System.out.println(solution.maxPathDown(t1));
    }

    /**
     * ½â·¨1
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    int maxValue;
    private int maxPathDown(TreeNode node) {
        if(node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left , right) + node.val;
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
