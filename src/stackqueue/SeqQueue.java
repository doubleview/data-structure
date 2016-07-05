package stackqueue;

/**
 * 顺序循环队列类，实现队列接口
 */
public class SeqQueue<T> implements QQueue<T> {

	private Object element[];// 存储队列数据元素的数组
	private int front, rear;// front和rear分别为队列头尾下标

	// 构造容量为length的空队列
	public SeqQueue(int length) {
		if (length < 64)
			length = 64;// 设置队列数组容量最小值
		this.element = new Object[Math.abs(length)];
		this.front = this.rear = 0;// 设置空队列
	}

	// 否早默认容量的空队列
	public SeqQueue() {
		this(64);
	}

	// 判断队列是否为空，若空则返回true
	public boolean isEmpty() {
		return this.front == this.rear;
	}

	@Override
	// 元素x入队，空对象不能入队
	public void enquenu(T x) {
		if (x == null)
			return;// 空对象不能入队
		if (this.front == (this.rear + 1) % this.element.length) {
			Object[] temp = this.element;
			this.element = new Object[temp.length * 2];// 重新申请一个容量更大的数组
			int i = this.front, j = 0;
			while (i != this.rear) {// 按照队列元素次序复制数组元素
				this.element[j] = temp[i];
				i = (i + 1) % temp.length;
				j++;
			}
			this.front = 0;
			this.rear = j;
		}
		this.element[this.rear] = x;
		this.rear = (this.rear + 1) % this.element.length;

	}

	@Override
	// 出队，返回对头元素，若空则返回null
	public T dequeue() {
		if (isEmpty())
			return null;// 若空则返回null
		@SuppressWarnings("unchecked")
		T temp = (T) this.element[front];// 取得对头元素
		this.front = (this.front + 1) % this.element.length;
		return temp;
	}

	// 返回队列 所有元素的描述字符串，按照队列元素次序
	public String toString() {
		String str = "(";
		if (!isEmpty()) {
			str = this.element[this.front].toString();
			int i = (this.front + 1) % this.element.length;
			while (i != this.rear) {
				str += "," + this.element[i].toString();
				i = (i + 1) % this.element.length;
			}
		}
		return str += ")";
	}
}