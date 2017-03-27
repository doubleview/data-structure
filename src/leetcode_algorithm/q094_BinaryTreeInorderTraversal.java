package leetcode_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**

Given a binary tree, return the inorder traversal of its nodes' values.

        For example:
        Given binary tree [1,null,2,3],
        1
            \
              2
            /
         3
        return [1,3,2].

        Note: Recursive solution is trivial, could you do it iteratively?

*/

public class q094_BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;

        q094_BinaryTreeInorderTraversal solution = new q094_BinaryTreeInorderTraversal();
        System.out.println(solution.inorderTraversal(root));

    }

    /**
     * 解法1 利用栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    private final static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
