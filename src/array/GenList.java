package array;

/**
 * 双链表示的广义表类
 */
public class GenList<T> implements GGenList<T> {

	public GenListNode<T> head;// 头指针,指向头结点

	// 构造空广义表，创建头结点，3个域均为null
	public GenList() {
		this.head = new GenListNode<T>();
	}

	// 构造广义表，由数组提供原子初值
	public GenList(T[] atoms) {// 由数组提供原子初值,算法同单链表,方法体省略
		this();
		GenListNode<T> rear = this.head;
		for (int i = 0; i < atoms.length; i++) {
			rear.next = new GenListNode<T>(atoms[i], null, null);
			rear = rear.next;
		}
	}

	@Override
	// 判断广义表是否为空
	public boolean isEmpty() {
		return head.next == null;
	}

	@Override
	// 返回广义表长度
	public int length() {
		int i = 0;
		GenListNode<T> rear = this.head.next;
		while (rear != null) {
			i++;
			rear = rear.next;
		}
		return i;
	}

	@Override
	// 返回广义表深度，递归方法
	public int depth() { // 返回广义表深度,递归方法
		int max = 1;
		GenListNode<T> p = this.head.next;
		while (p != null) {
			if (p.child != null) {
				int d = p.child.depth();// 递归调用，返回子表深度
				if (max <= d)// 记住最大子表深度
					max = d + 1;// 当前广义表深度为子表深度加1
			}
			p = p.next;
		}
		return max;
	}

	// 返回广义表所有元素对应的字符串，形式为"(,)",广义表遍历算法，递归方法
	public String toString() {// 递归调用,遍历子表添加子表描述字符窜
		String str = "(";
		GenListNode<T> p = this.head.next;
		while (p != null) {
			if (p.child == null)
				str += p.data.toString();
			else
				str += p.child.toString();// 递归调用，遍历子表添加子表描述字符串
			if (p.next != null)
				str += ",";
			p = p.next;
		}
		return str + ")";// 空表返回()
	}

	// 插入原子作为第i个元素
	public GenListNode<T> insert(int i, T x) {// 插入原子作为第i个元素,算法同单链表
		if (x == null)
			return null;
		GenListNode<T> p = this.head;
		for (int j = 0; j < i && p.next != null; j++) {
			p = p.next;
		}
		if (p != null)
			p.next = new GenListNode<T>(x, null, p.next);
		return p.next;
	}

	// 插入子表作为第i个元素
	public GenListNode<T> insert(int i, GenList<T> glist) {
		if (glist == null)
			return null;
		GenListNode<T> p = this.head;
		for (int j = 0; p.next != null && j < i; j++) {
			p = p.next;
		}
		p.next = new GenListNode<T>(null, glist, p.next);
		return p.next;
	}

	// 在广义表的最后添加原子节点
	public void append(T x) {
		this.insert(Integer.MAX_VALUE, x);
	}

	// 在广义表的最后添加子表
	public void append(GenList<T> glist) {
		this.insert(Integer.MAX_VALUE, glist);
	}
}
