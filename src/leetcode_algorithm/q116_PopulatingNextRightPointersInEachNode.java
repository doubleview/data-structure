package leetcode_algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**

Given a binary tree

        struct TreeLinkNode {
        TreeLinkNode *left;
        TreeLinkNode *right;
        TreeLinkNode *next;
        }
        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

        Initially, all next pointers are set to NULL.

        Note:

        You may only use constant extra space.
        You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
        For example,
        Given the following perfect binary tree,
        1
        /  \
        2    3
        / \  / \
        4  5  6  7
        After calling your function, the tree should look like:
        1 -> NULL
        /  \
        2 -> 3 -> NULL
        / \  / \
        4->5->6->7 -> NULL

*/

public class q116_PopulatingNextRightPointersInEachNode {


    /**
     * 解法1 (个人解法)
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        Queue<TreeLinkNode> tmp = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeLinkNode t = queue.poll();
                if(t.left!=null) tmp.offer(t.left);
                if(t.right!=null) tmp.offer(t.right);
                t.next = queue.peek();
            }
            queue.addAll(tmp);
            tmp.clear();
        }
    }

    /**
     * 解法2(推荐解法)
     * @param root
     */
    public void connect2(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while ((pre.left != null)) {
            cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if(cur.next!=null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
    }
    private static class TreeLinkNode{
        int val;
        TreeLinkNode left , right , next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
