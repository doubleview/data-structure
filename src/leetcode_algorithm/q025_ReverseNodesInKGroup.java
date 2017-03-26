package leetcode_algorithm;

/**

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a phonebook of k then left-out nodes in the end should remain as it is.

        You may not alter the values in the nodes, only nodes itself may be changed.

        Only constant memory is allowed.

        For example,
        Given this linked list: 1->2->3->4->5

        For k = 2, you should return: 2->1->4->3->5

        For k = 3, you should return: 3->2->1->4->5

*/

public class q025_ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        System.out.println(reverseKGroup(p1 , 3));
        //System.out.println(reverseKGroup(p1 , 2));
    }

    /**
     * 解法1 (个人解法)
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        if(k == 1) return head;
        ListNode p = head;
        ListNode next = null;
        int index = 0;
        ListNode[] group = new ListNode[k];
        group[index] = p;
        while (index < k - 1 && p.next != null) {
            p = p.next;
            next = p.next;
            index++;
            group[index] = p;
        }
        if (index == k - 1) {
            for(int i = group.length - 1; i >=1; i--) {
                group[i].next = group[i - 1];
            }
            group[0].next = reverseKGroup(next, k);
            return group[index];
        }
        return head;
    }

    /**
     * 解法2 (推荐解法)
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup2(curr, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
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
            return val + (next != null ? "->" + next.toString() : "");
        }
    }
}



