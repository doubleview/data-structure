package leetcode_algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

        For example,
        Given n = 3, your program should return all 5 unique BST's shown below.

        1         3     3      2      1
        \       /     /      / \      \
        3     2     1      1   3      2
        /     /       \                 \
        2     1         2                 3

*/

public class q095_UniqueBinarySearchTrees2 {


    public static void main(String[] args) {
        q095_UniqueBinarySearchTrees2 solution = new q095_UniqueBinarySearchTrees2();
        System.out.println(solution.generateTrees(3));
        System.out.println(solution.generateTrees(19));
    }


    /**
     * ½â·¨1
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return generateSubtrees(1, n);
    }

    private List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<>();
        if (s > e) {
            res.add(null);
            return res;
        }
        for(int i = s ; i<=e ;++i) {
            List<TreeNode> leftNodes = generateSubtrees(s , i-1);
            List<TreeNode> rightNodes = generateSubtrees(i + 1, e);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
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
