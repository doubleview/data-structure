package stackqueue;

import list.SortedSinglyLinkedList;

/**
 * 
 * 排序单链表
 */
public class PriorityQueue<T extends Comparable<T>> implements QQueue<T> {

	private SortedSinglyLinkedList<T> list;// 使用排序单链表存储队列元素

	// 构造空队列
	public PriorityQueue() {
		this.list = new SortedSinglyLinkedList<T>();
	}

	// 判断队列是否为空，若空则返回true
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	// /元素x入队，空对象不能入队，根据元素大小插入在单链表适当位置
	public void enquenu(T x) {
		list.insert(x);
	}

	@Override
	// 出队，返回对头元素，若队列空，返回null，remove函数返回对头元素，删除对头元素
	public T dequeue() {
		return list.remove(0);
	}

	// 返回队列所有元素的描述字符串
	public String toString() {
		return list.toString();
	}
}