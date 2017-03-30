package leetcode_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**

Given a binary tree, determine if it is a valid binary search tree (BST).

        Assume a BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.
        Example 1:
        2
        / \
        1   3
        Binary tree [2,1,3], return true.
        Example 2:
        1
        / \
        2   3
        Binary tree [1,2,3], return false.

*/

public class q098_ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t2.left = t1;
        t2.right = t3;

        q098_ValidateBinarySearchTree solution = new q098_ValidateBinarySearchTree();
        System.out.println(solution.isValidBST(t2));

        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(3);
        t4.left = t5;
        t4.right = t6;
        System.out.println(solution.isValidBST(t4));
    }



    /**
     * 解法1 通过中序遍历，每加入一个元素，必然比上一个元素大
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(!list.isEmpty() && cur.val <= list.get(list.size() - 1)) return false;
            list.add(cur.val);
            cur = cur.right;
        }
        return true;
    }

    /**
     * 解法2
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if(root == null) return true;
        if(root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
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
