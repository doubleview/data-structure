package leetcode_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */

public class q113_PathSum2 {


    /**
     * ½â·¨1
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, sum, result, new ArrayList<>());
        return result;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> tmp) {
        if (root == null) return;
        tmp.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }
        pathSum(root.left, sum - root.val, result, tmp);
        pathSum(root.right, sum - root.val, result, tmp);
        tmp.remove(tmp.size() - 1);
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
