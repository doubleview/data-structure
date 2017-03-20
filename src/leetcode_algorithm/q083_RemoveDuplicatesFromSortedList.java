package leetcode_algorithm;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * <p>
 * Subscribe to see which companies asked this question.
 */

public class q083_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        q083_RemoveDuplicatesFromSortedList solution = new q083_RemoveDuplicatesFromSortedList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(solution.deleteDuplicates(l1));
        System.out.println(solution.deleteDuplicates2(l1));
    }

    /**
     * 解法1
     * 利用pNext判断有木有重复节点
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        ListNode pNext = p.next;
        while (pNext != null) {
            if (pNext.val == p.val) {
                while (pNext != null && pNext.val == p.val) {
                    pNext = pNext.next;
                }
                p.next = pNext;
            } else {
                p = pNext;
                pNext = pNext.next;
            }
        }
        return head;
    }

    /**
     * 解法2 利用递归
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode p = head.next;
        if (p != null && p.val == head.val) {
            while (p != null && p.val == head.val) {
                p = p.next;
            }
            head.next = deleteDuplicates2(p);
        } else {
            head.next = deleteDuplicates2(head.next);
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            return val + (next == null ? "" : "->" + next.toString());
        }
    }
}
