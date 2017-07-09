package leetcode_algorithm;


/**

Sort a linked list using insertion sort.

*/

public class q147_InsertionSortList {


    /**
     * ½â·¨1
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode helper = new ListNode(0);
        ListNode cur = head;
        ListNode pre = helper;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }
        return helper.next;
    }


    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

}
