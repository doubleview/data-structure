package leetcode_algorithm;

/**

Given two binary trees, write a function to check if they are equal or not.

        Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

*/

public class q100_SameTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t2.left = t1;
        t2.right = t3;


        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(3);
        t4.left = t5;
        t4.right = t6;

        q100_SameTree solution = new q100_SameTree();
        System.out.println(solution.isSameTree(t1 , t4));
    }


    /**
     * ½â·¨1
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q ==null) return true;
        if(p!=null && q!=null)
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
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
