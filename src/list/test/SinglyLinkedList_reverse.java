package list.test;

import list.Node;
import list.SinglyLinkedList;

/**
 * 将单链表进行逆转
 */
public class SinglyLinkedList_reverse {

	public static <T> void reverse(SinglyLinkedList<T> list) {
		Node<T> p = list.head.next, succ = null, front = null;
		while (p != null) {
            succ = p.next;// 设置succ是p节点的后继节点
            p.next = front;// p.next指向p节点的前驱节点
            front = p;
            p = succ;// p向后走一步
        }
        list.head.next = front;//将head移到尾部
    }

	public static void main(String[] args) {
		String values[] = { "A", "B", "C", "D", "E", "F" };
		SinglyLinkedList<String> list = new SinglyLinkedList<String>(values);
		System.out.println("list :  " + list.toString());
		reverse(list);
        System.out.println("逆转后 : " + list.toString());
    }
}
