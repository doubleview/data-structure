package leetcode_algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */

public class q106_ConstructBinaryTreeFromInorderAndPostorder {

    public static void main(String[] args) {
        q106_ConstructBinaryTreeFromInorderAndPostorder solution = new q106_ConstructBinaryTreeFromInorderAndPostorder();
        TreeNode node = solution.buildTree(new int[]{2, 1, 3}, new int[]{2, 3, 1});
        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.right.val);
    }

    /**
     * ½â·¨1
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> hm) {
        if (postStart > postEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rIndex = hm.get(postorder[postEnd]);
        root.left = buildTreePostIn(inorder, inStart, rIndex - 1, postorder, postStart, postStart + rIndex - inStart - 1, hm);
        root.right = buildTreePostIn(inorder, rIndex + 1, inEnd, postorder, postStart + rIndex - inStart, postEnd - 1, hm);
        return root;
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
