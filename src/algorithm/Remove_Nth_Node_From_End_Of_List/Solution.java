package algorithm.Remove_Nth_Node_From_End_Of_List;


import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        ListNode x1 = new ListNode(1);
        ListNode x2 = new ListNode(2);
        ListNode x3 = new ListNode(3);
        ListNode x4 = new ListNode(4);
        ListNode x5 = new ListNode(5);
        x1.next = x2;
        x2.next = x3;
        x3.next = x4;
        x4.next = x5;

        System.out.println(removeNthFromEnd(x1, 1).val);

        x1 = new ListNode(1);
        x2 = new ListNode(2);
        x1.next = x2;
        System.out.println(removeNthFromEnd(x1, 1).val);
    }


    /**
     * 个人解法
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();

        ListNode p = head;
        int num = 0;
        while (p != null) {
            map.put(num++, p);
            p = p.next;
        }
        if (num - n == 0) {
            head = head.next;
        }else {
            map.get(num-n - 1).next = map.get(num - n).next;
        }
        return  head;
    }


    /**
     * 推荐解法
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start , fast = start;
        slow.next = head;

        for(int i = 1; i<=n+1;i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}



class ListNode{

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}