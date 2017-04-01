package leetcode_algorithm;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * <p>
 * Subscribe to see which companies asked this question.
 */

public class q061_RotateList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(new q061_RotateList().rotateRight(l1, 2));
    }


    /**
     *  解法1(个人解法)
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        ListNode end = head;
        int endIndex = 0;
        while (end.next != null) {
            end = end.next;
            endIndex++;
        }
        k = k % (endIndex + 1);

        int position = 0;
        ListNode phead = head;
        while (position < endIndex - k) {
            phead = phead.next;
            position++;
        }

        end.next = head;
        ListNode pnext = phead.next;
        phead.next = null;
        return pnext;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            return val + (next != null ? "->" + next.toString() : "");
        }
    }

}


