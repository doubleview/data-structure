package stackqueue;

/**
 * 链式队列类，实现队列接口
 */
public class LinkedQueue<T> implements QQueue<T> {

	// front和rear分别指向对头和对尾
	private Node<T> front, rear;

	// 构造空队列
	public LinkedQueue() {
		this.front = this.rear = null;
	}

	@Override
	// 判断队列是否为空，若空则返回true
	public boolean isEmpty() {
		return this.front == null && this.rear == null;
	}

	@Override
	// 元素x入队，空对象不能入队
	public void enquenu(T x) {
		if (x == null)
			return;// 空对象不能入队
		Node<T> q = new Node<T>(x, null);
		if (this.front == null)
			this.front = q;// 空对插入
		else
			this.rear.next = q;// 插入在队列之尾
		this.rear = q;
	}

	@Override
	// 出队，返回对头元素，若队列空则返回null
	public T dequeue() {
		if (isEmpty())
			return null;
		T temp = this.front.data;// 取得对头元素
		this.front = this.front.next;// 删除对头元素
		if (this.front == null)
			this.rear = null;
		return temp;
	}
}
