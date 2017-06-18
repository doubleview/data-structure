package leetcode_algorithm;

import java.util.*;

/**

Given a binary tree, return the preorder traversal of its nodes' values.

        For example:
        Given binary tree {1,#,2,3},
        1
        \
        2
        /
        3
        return [1,2,3].

*/

public class q144_BinaryTreePreorderTraversal {


    /**
     * 解法1(利用递归)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> orderList = new ArrayList<>();
        preorderTraversal(orderList , root);
        return orderList;
    }

    private void preorderTraversal(List<Integer> orderList, TreeNode root) {
        if(root == null) return;
        orderList.add(root.val);
        preorderTraversal(orderList , root.left);
        preorderTraversal(orderList, root.right);
    }


    /**
     * 解法2(利用栈，非递归算法)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode p = root;
        while (!deque.isEmpty() || p != null) {
            if (p != null) {
                list.add(p.val);
                deque.push(p);
                p = p.left;
            }else {
                p = deque.pop().right;
            }
        }
        return list;

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
