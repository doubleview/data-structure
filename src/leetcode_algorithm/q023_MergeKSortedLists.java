package leetcode_algorithm;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

public class q023_MergeKSortedLists {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(5);
        ListNode a3 = new ListNode(6);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(7);
        ListNode b3 = new ListNode(8);
        ListNode b4 = new ListNode(11);
        ListNode b5 = new ListNode(13);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;

        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(3);
        ListNode c3 = new ListNode(4);
        ListNode c4 = new ListNode(18);
        ListNode c5 = new ListNode(19);
        c1.next = c2;
        c2.next = c3;
        c3.next = c4;
        c4.next = c5;

        System.out.println(mergeKLists(new ListNode[]{a1 ,b1 , c1}));
    }

    /**
     * 解法1 (个人解法)
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(0);
        ListNode p  = head;

        ListNode[] position = new ListNode[lists.length];
        for(int i = 0; i < lists.length; i++) {
            position[i] = lists[i];
        }
        int min = Integer.MAX_VALUE;
        int index = -1;
        while (true) {
            boolean allEmpty = true;
            for (ListNode pp : position) {
                if (pp != null) {
                    allEmpty = false;
                }
            }
            if (allEmpty) {
                break;
            }
            //找出最小值
            for(int i = 0; i< position.length;i++) {
                int val = position[i] == null ? Integer.MAX_VALUE : position[i].val;
                if(val < min){
                    min = val;
                    index = i;
                }
            }
            min = Integer.MAX_VALUE;
            p.next = new ListNode(position[index].val);
            p  = p.next;
            position[index] = position[index].next;
        }
        return head.next;
    }


    /**
     * 解法2 推荐，采用优先级队列算法
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return  null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val < o2.val)
                    return -1;
                else if(o1.val == o2.val)
                    return  0;
                else
                    return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode tail  = dummy;
        for (ListNode node : lists) {
            if(node!= null)
                queue.add(node);
        }
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
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

