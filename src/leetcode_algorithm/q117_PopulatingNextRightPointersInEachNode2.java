package leetcode_algorithm;

import java.util.LinkedList;
import java.util.Queue;
/**

Follow up for problem "Populating Next Right Pointers in Each Node".

        What if the given tree could be any binary tree? Would your previous solution still work?

        Note:

        You may only use constant extra space.
        For example,
        Given the following binary tree,
        1
        /  \
        2    3
        / \    \
        4   5    7
        After calling your function, the tree should look like:
        1 -> NULL
        /  \
        2 -> 3 -> NULL
        / \    \
        4-> 5 -> 7 -> NULL

*/


public class q117_PopulatingNextRightPointersInEachNode2 {


    /**
     * 解法1
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        Queue<TreeLinkNode> tmp = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeLinkNode t = queue.poll();
                if (t.left != null) tmp.offer(t.left);
                if (t.right != null) tmp.offer(t.right);
                t.next = queue.peek();
            }
            queue.addAll(tmp);
            tmp.clear();
        }
    }


    /**
     * 解法2
     *
     * @param root
     */
    public void connect2(TreeLinkNode root) {
        TreeLinkNode head = null;//head of the next level
        TreeLinkNode prev = null;//the leading node on the next level
        TreeLinkNode cur = root;// current node of current level
        while (cur != null) {
            while (cur != null) {
                //left child
                if (cur.left != null) {
                    if (prev != null) prev.next = cur.left;
                    else head = cur.left;
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) prev.next = cur.right;
                    head = cur.right;
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            prev = null;
        }
    }


    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
