package leetcode_algorithm;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * <p>
 * Subscribe to see which companies asked this question.
 */

public class q082_RemoveDuplicatesFromSortedList2 {

    public static void main(String[] args) {
        q082_RemoveDuplicatesFromSortedList2 solution = new q082_RemoveDuplicatesFromSortedList2();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        System.out.println(solution.deleteDuplicates(l1));
    }

    /**
     * 解法1
     * 利用pNext节点每次判断有木有重复的，position为上一个节点
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode pNext = head;
        ListNode postion = p;
        while (pNext != null) {
            //判断有没有重复节点
            if (pNext.next != null && pNext.next.val == pNext.val) {
                int v = pNext.val;
                while (pNext != null && pNext.val == v) {
                    pNext = pNext.next;
                }
                postion.next = pNext;
            } else {
                pNext = pNext.next;
                postion = postion.next;
            }
        }
        return p.next;
    }

    /**
     * 解法2 利用递归
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
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
