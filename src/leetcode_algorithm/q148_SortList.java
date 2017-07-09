package leetcode_algorithm;

/**
Sort a linked list in O(n log n) time using constant space complexity.
*/

public class q148_SortList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        q148_SortList solution = new q148_SortList();
        System.out.println(solution.sortList(l1));
    }


    /**
     * ½â·¨1
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null , slow = head , fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0) , p = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null)
            p.next = l1;
        if(l2 != null)
            p.next = l2;
        return l.next;
    }

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

        public String toString() {
            return val + (next != null ? "->" + next.toString() : "");
        }
    }
}
