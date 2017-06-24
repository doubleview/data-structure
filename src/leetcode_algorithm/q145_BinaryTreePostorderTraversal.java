package leetcode_algorithm;



import java.util.*;

/**

Given a binary tree, return the postorder traversal of its nodes' values.

        For example:
        Given binary tree {1,#,2,3},
        1
        \
        2
        /
        3
        return [3,2,1].

*/

public class q145_BinaryTreePostorderTraversal {

    /**
     * 解法1(递归算法)
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) return;
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }


    /**
     * 解法2(非递归算法)
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.addFirst(p.val);
                p = p.right;
            }else {
                TreeNode node = stack.pop();
                p = node.left;
            }
        }
        return result;
    }
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
