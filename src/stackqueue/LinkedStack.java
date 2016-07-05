package stackqueue;

/**
 * 单恋表存储的栈
 */
public class LinkedStack<T> implements SStack<T> {

	private Node<T> top;// 栈顶结点，实现栈接口

	// 构造空栈
	public LinkedStack() {
		this.top = null;
	}

	@Override
	// 判断栈是否为空，若空则返回true
	public boolean isEmpty() {
		return this.top == null;
	}

	@Override
	// 元素x入栈，空对象不能入栈
	public void push(T x) {
		if (x != null) {
			this.top = new Node<T>(x, this.top);// 头插入，x结点作为新的栈顶结点
		}
	}

	@Override
	// 出栈，返回栈顶元素，若栈空返回null
	public T pop() {
		if (this.top == null)
			return null;
		T temp = this.top.data;// 取栈顶结点
		this.top = this.top.next;// 删除栈顶元素
		return temp;
	}

	@Override
	// 取栈顶元素，未出栈，若栈空返回null
	public T get() {
		return this.top == null ? null : this.top.data;
	}
}

class Node<T> {

	public T data;
	public Node<T> next;

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public Node() {
		this(null, null);
	}
}
