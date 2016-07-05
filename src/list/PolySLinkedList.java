package list;

/**
 * 可排序并且可加的单链表
 */
public class PolySLinkedList<T extends Comparable<T> & Addible<T>> extends
		SortedSinglyLinkedList<T> {

	// 默认构造方法
	public PolySLinkedList() {
		super();
	}

	// 由项目组指定多项式各项值
	public PolySLinkedList(T terms[]) {
		super(terms);
	}

	public PolySLinkedList(PolySLinkedList<T> polylist) {
		super(polylist);
	}

	// 将两个链表进行相加的方法
	public void add(PolySLinkedList<T> polylist) {
		Node<T> front = this.head, p = front.next;
		Node<T> q = polylist.head.next;
		while (p != null && q != null) {
			if (p.data.compareTo(q.data) == 0) {// 两项大小相同
				p.data.add(q.data);
				if (p.data.removeable()) {// 相加后的元素满足删除条件
					front.next = p.next;// 删除后的元素不需要存储，删除p节点
					p = front.next;
				} else {
					front = p;
					p = p.next;
				}
				q = q.next;
			} else if (p.data.compareTo(q.data) < 0) {
				front = p;
				p = p.next;
			} else {
				front.next = new Node<T>(q.data, p);
				q = q.next;
			}
		}

		while (q != null) {
			front.next = new Node<T>(q.data, p);
			front = front.next;
			q = q.next;
		}
	}
}