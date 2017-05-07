package leetcode_algorithm;
/**

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

        An example is the root-to-leaf path 1->2->3 which represents the number 123.

        Find the total sum of all root-to-leaf numbers.

        For example,

        1
        / \
        2   3
        The root-to-leaf path 1->2 represents the number 12.
        The root-to-leaf path 1->3 represents the number 13.

        Return the sum = 12 + 13 = 25.
*/

public class q129_SumRootToLeafNumbers {


    public static void main(String[] args) {
        q129_SumRootToLeafNumbers solution = new q129_SumRootToLeafNumbers();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(solution.sumNumbers(t1));
    }

    int sum;

    /**
     * 解法1 (个人解法)
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        sumNumbers(root , 0);
        return sum;
    }

    private void sumNumbers(TreeNode root, int val) {
        if(root == null) return;
        val = val*10+root.val;
        if (root.right == null && root.left == null) {
            sum+=val;
            return;
        }
        sumNumbers(root.right, val);
        sumNumbers(root.left, val);
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
