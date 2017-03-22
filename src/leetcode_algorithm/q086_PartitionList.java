package leetcode_algorithm;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */

public class q086_PartitionList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        q086_PartitionList solution = new q086_PartitionList();
        System.out.println(solution.partition(l1, 3));

        ListNode s1 = new ListNode(2);
        ListNode s2 = new ListNode(1);
        s1.next = s2;
        System.out.println(solution.partition(s1, 2));
    }

    /**
     * 解法1
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);//两个链表的头结点
        ListNode curr1 = dummy1, curr2 = dummy2;     //两个链表的尾节点
        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //避免循环引用
        curr1.next = dummy2.next;//将两个链表结合
        return dummy1.next;
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