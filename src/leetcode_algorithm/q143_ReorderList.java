package leetcode_algorithm;


import java.util.Deque;
import java.util.LinkedList;

/**

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
        reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

        You must do this in-place without altering the nodes' values.

        For example,
        Given {1,2,3,4}, reorder it to {1,4,2,3}.

*/


public class q143_ReorderList {


    /**
     * 个人解法(利用双端队列)
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;

        ListNode p = head;
        Deque<ListNode> deque = new LinkedList<>();
        while (p != null) {
            deque.offer(p);
            p = p.next;
        }
        ListNode prev = new ListNode(0);
        while (!deque.isEmpty()) {
            if (deque.size() == 1) {
                prev.next = deque.pollFirst();
                return;
            }
            prev.next = deque.peekFirst();
            prev  = deque.peekLast();
            deque.pollFirst().next = deque.pollLast();
        }
    }


    /**
     * 解法2
     * @param head
     */
    public void reorderList1(ListNode head) {
        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
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
