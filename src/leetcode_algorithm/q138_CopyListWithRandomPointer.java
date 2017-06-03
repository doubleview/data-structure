package leetcode_algorithm;


import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 *
 * Return a deep copy of the list.
 */

public class q138_CopyListWithRandomPointer {


    /**
     * 解法1
     * 利用Map将老的链表与新的链表的元素一一对应
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }


    /**
     * 解法2
     * @param head
     * @return
     */
    public RandomListNode copyRandomList2(RandomListNode head) {

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        RandomListNode iter = head , next;
        while (iter != null) {
            next = iter.next;
            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;
            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }


        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;
        while (iter != null) {
            next = iter.next.next;

            //extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            //restore the original list
            iter.next = next;
            iter = next;
        }

        return pseudoHead.next;
    }


    private class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }
    }



}
