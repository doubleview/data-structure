package stackqueue;

/**
 * 顺序存储的栈,实现栈接口
 */
public class SeqStack<T> implements SStack<T> {

	private Object element[];// 存储栈数据元素的数组
	private int top;// 栈顶元素下标

	// 构造默认容量的空栈
	public SeqStack(int size) {
		this.element = new Object[Math.abs(size)];
		this.top = -1;
	}

	// 构造默认容量的空栈
	public SeqStack() {
		this(64);
	}

	@Override
	// 判断栈是否为空，若空则返回true
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	// 元素x入栈，空元素不能入栈
	public void push(T x) {
		if (x == null) {// 空对象不能入栈
			return;
		}
		if (this.top == element.length - 1) {// 若栈满，则扩充栈容量
			Object[] temp = this.element;
			this.element = new Object[temp.length * 2];// 重新申请一个容量更大的数组
			// 复制数组元素
			for (int i = 0; i < temp.length; i++)
				this.element[i] = temp[i];
		}
		this.top++;
		this.element[this.top] = x;
	}

	@SuppressWarnings("unchecked")
	@Override
	// 出栈，返回栈顶元素，若栈空则返回null
	public T pop() {
		return this.top == -1 ? null : (T) element[top--];
	}

	@SuppressWarnings("unchecked")
	@Override
	// 取栈顶元素，未出栈，若栈空则返回null
	public T get() {
		return this.top == -1 ? null : (T) element[top];
	}
}