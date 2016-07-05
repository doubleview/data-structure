package list;

/**
 * 顺序表
 */
public class SeqList<T> implements LList<T> {

	private Object[] element;// 对象数组
	private int len;// 顺序表长度，记载实际元素长度

	public SeqList(int size) {// 创建容量为size的空表
		this.element = new Object[size];
		this.len = 0;
	}

	public SeqList() {// 默认构造方法.创建默认容量的空表
		this(64);
	}

	// 判断是否为空，若空返回true
	public boolean isEmpty() {
		return this.len == 0;
	}

	// 返回顺序表的长度
	public int length() {
		return this.len;
	}

	// 返回第i元素，若i指定序号无效则返回null
	@SuppressWarnings("unchecked")
	public T get(int i) {
		if (i >= 0 && i < this.len) {
			return (T) this.element[i];
		}
		return null;
	}

	@Override
	// 设置第i个元素为x，若i指定序号无效则抛出序号越界异常
	public void set(int i, T x) {
		if (x == null) {
			return;
		}
		if (i >= 0 && i < this.len) {
			this.element[i] = x;
		} else
			throw new IndexOutOfBoundsException(i + "");// 抛出序号越界异常
	}

	@Override
	// 插入x作为第i个元素，不能插入null
	public void insert(int i, T x) {
		if (x == null)
			return;
		if (this.len == element.length) {
			Object[] temp = this.element;
			this.element = new Object[temp.length * 2];
			for (int j = 0; j < temp.length; j++)
				this.element[j] = temp[j];
		}
		if (i < 0)
			i = 0;// 下标容错
		if (i > this.len)
			i = this.len;
		for (int j = this.len - 1; j >= i; j--)
			// 元素后移，平均移动len/2
			this.element[j + 1] = this.element[j];
		this.element[i] = x;
		this.len++;
	}

	// 在顺序表最后插入x对象
	public void append(T x) {
		this.insert(this.len, x);
	}

	@Override
	// 删除第i个元素，若操作成功返回被删除对象，否则返回null
	public T remove(int i) {
		if (this.len == 0 || i >= this.len || i < 0)
			return null;
		@SuppressWarnings("unchecked")
		T old = (T) this.element[i];
		for (int j = i; j < this.len - 1; j++)
			// 元素前移，平均移动len/2
			this.element[j] = this.element[j + 1];
		this.element[this.len - 1] = null;
		this.len--;
		return old;
	}

	@Override
	// 删除顺序表所有元素
	public void removeall() {
		this.len = 0;
	}

	// 删除首次出现的关键字为key元素
	public void remove(T key) {
		if (this.len != 0 && key != null)
			this.remove(this.indexOf(key));// 调用remove（int）方法
	}

	// 顺序表查找关键字是key元素，返回首次出现的元素，若查找不成功则返回-1
	// key可以包含关键字数据域，由T类的equals方法提供比较对象相等的依据
	public int indexOf(T key) {
		if (key != null)
			for (int i = 0; i < this.len; i++)
				if (this.element[i].equals(key))// 对象采用equals方法比较是否相等
					return i;
		return -1;
	}

	// 查找，返回首次出现的关键字为key的元素
	@SuppressWarnings("unchecked")
	public T search(T key) {
		int find = this.indexOf(key);
		return find == -1 ? null : (T) this.element[find];
	}

	// 判断线性表是否包含关键字为key的元素
	public boolean contain(T key) {
		return this.indexOf(key) >= 0;// 以查找结果获得判断结果
	}

	// 返回顺序表所有元素描述字符串
	public String toString() {
		String str = "(";
		if (this.len > 0)
			str += this.element[0].toString();
		for (int i = 1; i < this.len; i++) {
			str += "," + this.element[i].toString();
		}
		return str + ")";
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof SeqList) {
			@SuppressWarnings("unchecked")
			SeqList<T> list = (SeqList<T>) obj;
			if (this.length() == list.length()) {
				for (int i = 0; i < this.length(); i++)
					// 比较实际长度元素，而非数组容量
					if (!(this.get(i).equals(list.get(i))))
						return true;
			}
		}
		return false;
	}
}