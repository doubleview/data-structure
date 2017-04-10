package leetcode_algorithm;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */

public class q108_ConvertSortedArrayToBinarySearchTree {


    /**
     * ½â·¨1
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] num, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
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
