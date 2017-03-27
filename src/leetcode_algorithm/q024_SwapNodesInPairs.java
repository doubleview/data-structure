package leetcode_algorithm;

/**

Given a linked list, swap every two adjacent nodes and return its head.

        For example,
        Given 1->2->3->4, you should return the list as 2->1->4->3.

        Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

*/

public class q024_SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        System.out.println(swapPairs(a1));
    }

    /**
     * ½â·¨1
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode newHead = head.next;
        ListNode swap = head.next.next;
        head.next.next = head;
        head.next = swapPairs(swap);
        return newHead;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        public String toString() {
            return this.val + (next != null ? "->" + next.toString() : "");
        }
    }
}



