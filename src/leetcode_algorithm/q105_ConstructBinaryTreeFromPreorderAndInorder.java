package leetcode_algorithm;


/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */


public class q105_ConstructBinaryTreeFromPreorderAndInorder {

    public static void main(String[] args) {
        q105_ConstructBinaryTreeFromPreorderAndInorder solution = new q105_ConstructBinaryTreeFromPreorderAndInorder();
        TreeNode node = solution.buildTree(new int[]{1, 2, 3}, new int[]{2, 1, 3});
        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.right.val);
    }

    /**
     * ½â·¨1
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) inIndex = i;
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
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
