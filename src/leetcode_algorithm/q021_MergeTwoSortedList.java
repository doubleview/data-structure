package leetcode_algorithm;


public class q021_MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode p1 = new ListNode(4);
        ListNode p2 = new ListNode(6);
        ListNode p3 = new ListNode(7);
        ListNode p4 = new ListNode(10);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(10);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println(mergeTwoLists(p1 , n1));
    }

    /**
     * 解法1 (个人解法)
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null || l2 != null) {
            if(l1 == null){
                p.next = new ListNode(l2.val);
                p = p.next;
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                p.next = new ListNode(l1.val);
                p = p.next;
                l1 = l1.next;
                continue;
            }
            if (l1.val < l2.val) {
                p.next = new ListNode(l1.val);
                p = p.next;
                l1 = l1.next;
            }else {
                p.next = new ListNode(l2.val);
                p = p.next;
                l2 = l2.next;
            }
        }
        return head.next;
    }


    /**
     * 解法2 (推荐解法)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode mergeHead ;

        if (l1.val < l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists2(l1.next, l2);
        }else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
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


