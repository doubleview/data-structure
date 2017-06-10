package leetcode_algorithm;

/**

Given a linked list, determine if it has a cycle in it.

        Follow up:
        Can you solve it without using extra space?

*/

public class q141_LinkedListCycle {


    /**
     * ½â·¨1
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode walker = null;
        ListNode runner = null;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner) return true;
        }
        return false;
    }



    private static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
