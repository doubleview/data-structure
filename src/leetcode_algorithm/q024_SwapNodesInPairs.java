package leetcode_algorithm;

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



