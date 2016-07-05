package list;

/**
 * 排序单链表
 */
public class SortedSinglyLinkedList<T extends Comparable<T>> extends
		SinglyLinkedList<T> {

	// 构造空排序单链表 
	public SortedSinglyLinkedList() {
		super();
	}

	// 以结点元素构造单链表
	public SortedSinglyLinkedList(T[] element) {
		super();
		if (element != null)
			for (int i = 0; i < element.length; i++) {
				this.insert(element[i]);
			}
	}

	// 深拷贝构造方法，由单链表list构造排序单链表，直接选择排序
	public SortedSinglyLinkedList(SortedSinglyLinkedList<T> list) {
		super(list);// 深拷贝list单链表
		Node<T> srear = head;// 指向排序单链表尾
		while (srear.next != null) {// 原单链表不空
			Node<T> mfront = srear, min = mfront.next;// 指向最小值结点，mfrong指向min的前驱
			Node<T> pfront = min, p = min.next;// p遍历单链表，pfront指向p的前驱结点

			while (p != null) {
				if (p.data.compareTo(min.data) < 0) {// 比较，min记住最小值结点
					mfront = pfront;// mfront是min的前驱结点
					min = p;
				}
				pfront = p;// pfront是p的前驱结点
				p = p.next;
			}

			if (mfront != srear) {
				mfront.next = min.next;// 从链表原位置删除min结点
				min.next = srear.next;// 将min结点插入到srear之后
				srear.next = min;
			}
			srear = min;// srear指向排序单链表的结尾
		}
	}

	// 排序单链表的归并算法
	public void merge(SortedSinglyLinkedList<T> list) {
		Node<T> front = this.head, p = head.next;// p指向this单链表的第一个结点
		Node<T> q = list.head.next;// q指向list单链表表的第一个结点
		while (p != null && q != null) {
			if (p.data.compareTo(q.data) < 0) {// 比较两个单链表
				front = p;// front指向p的前驱结点
				p = p.next;
			} else {// 将q结点插入到front结点之后
				front.next = q;
				q = q.next;
				front = front.next;
				front.next = p;
			}
		}
		if (q != null) {// 将list链表中剩余结点并入当前链表尾
			front.next = q;
			list.head.next = null;// 设置list单链表设置为空单链表
		}
	}

	// 重载父类的insert方法，因参数不同没有覆盖父类的insert方法
	public void insert(T x) {
		if (x == null)
			return;
		Node<T> front = this.head, p = front.next;
		while (p != null && p.data.compareTo(x) < 0) {
			front = p;
			p = p.next;
		}
		front.next = new Node<T>(x, p);
	}

	// 不支持父类的insert方法和append方法，将其覆盖并抛出异常
	public void insert(int i, T x) {
		throw new UnsupportedOperationException("insert(int i,T x)");
	}

	// 不支持该方法
	public void append(T x) {
		throw new UnsupportedOperationException("append(T x)");
	}

	// 重载父类的remove方法，因参数不同没有覆盖父类的remove方法
	public void remove(T x) {
		if (x == null)
			return;
		Node<T> front = this.head, p = front.next;
		while (p != null && p.data.compareTo(x) < 0) {
			front = p;
			p = p.next;
		}

		if (p != null && p.data.compareTo(x) == 0)
			front.next = p.next;
	}

	// 顺序查找关键字为key元素，返回首次出现的元素，若查找不成功则返回null
	// key只可以包含关键字数据项，由T类的compareTo提供比较对象大小和相等的依据
	// 覆盖父类SinglyLinkedList的同名方法
	public T search(T key) {
		if (key == null)
			return null;
		Node<T> p = this.head.next;
		while (p != null && p.data.compareTo(key) <= 0) {
			if (p.data.compareTo(key) == 0)
				return p.data;
			p = p.next;
		}
		return null;
	}
}