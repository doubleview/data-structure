package leetcode_algorithm;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */

public class q114_FlattenBinaryTreToLinkedList {

    private TreeNode prev = null;

    /**
     * 解法1
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    /**
     * 解法2
     *
     * @param root
     */
    public void flatten1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            if (curr.right != null) stk.push(curr.right);
            if (curr.left != null) stk.push(curr.left);
            if (!stk.isEmpty()) curr.right = stk.peek();
            curr.left = null;
        }
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
