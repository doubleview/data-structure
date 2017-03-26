package list.test;

import list.SortedSinglyLinkedList;

/**
 * 验证排序的单链表算法
 */
public class SortedSinglyLinkedList_ex {

	public static Integer[] random(int n) {
		Integer[] element = new Integer[n];
		for (int i = 0; i < n; i++)
			element[i] = new Integer((int) (Math.random() * 100));
		return element;
	}

	public static void main(String[] args) {
		SortedSinglyLinkedList<Integer> list1 = new SortedSinglyLinkedList<Integer>(
				random(9));
		System.out.println("list1 :  " + list1.toString());

		list1.insert(-2);
		SortedSinglyLinkedList<Integer> list2 = new SortedSinglyLinkedList<Integer>(
				list1);
		System.out.println("list2 : " + list2.toString());

		list1.remove(list1.length() - 1);
		list1.remove(list1.get(0));
		list1.remove(new Integer(50));
		System.out.println("list1 : " + list1.toString());
	}
}