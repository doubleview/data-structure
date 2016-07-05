package string;

import java.io.Serializable;

/**
 * 模拟变量字符串
 */
public final class MyStringBuffer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private char[] value;// 字符数组，私有成员变量
	private int len;// 串长度

	// 构造指定容量的空串
	public MyStringBuffer(int size) {
		this.value = new char[size < 16 ? 16 : size];
		this.len = 0;
	}

	// 以默认容量构造字符串对象
	public MyStringBuffer() {
		this(16);
	}

	// 以字符串常量构造对象
	public MyStringBuffer(String str) {
		this(str.length() + 16);
		this.append(str);
	}

	// 返回变量字符串的长度
	public int length() {
		return this.len;
	}

	// 返回指定位置的字符
	public synchronized char charAt(int i) {
		if (i < 0 || i > this.len)
			throw new StringIndexOutOfBoundsException(i);
		return this.value[i];
	}

	// 将指定位置设置为指定字符
	public void setChar(int i, char ch) {
		if (i < 0 || i > this.len)
			throw new StringIndexOutOfBoundsException(i);
		this.value[i] = ch;
	}

	// 重写toString方法
	public synchronized String toString() {
		return new String(this.value, 0, this.len);
	}

	// 向指定位置插入变量字符串
	public synchronized MyStringBuffer insert(int i, MyStringBuffer str) {
		if (i < 0)
			i = 0;// 序号容错
		if (i > this.len)
			i = this.len;
		if (str == null)
			return this;
		char temp[] = this.value;
		if (this.value.length - this.len < str.len) {// 若当前串空间不足，则扩充容量
			this.value = new char[this.value.length + str.len * 2];// 重新申请字符数组空间
			// 赋值当前串前i-1个字符
			for (int j = 0; j < i; j++)
				this.value[j] = temp[j];
		}
		// 赋值字符串str
		for (int j = 0; j < str.len; j++)
			this.value[i + j] = str.value[j];
		// 赋值字符串str
		for (int j = i; j < this.len; j++)
			this.value[str.len + j] = temp[j];
		this.len += str.len;
		return this;
	}

	// 向指定位置插入字符串
	public synchronized MyStringBuffer insert(int i, String str) {
		if (i < 0)
			i = 0;
		if (i > this.len)
			i = this.len;
		if (str == null)
			return this;
		char temp[] = this.value;
		if (this.value.length - this.len < str.length()) {
			this.value = new char[this.value.length + str.length() * 2];
			for (int j = 0; j < i; j++)
				this.value[j] = temp[j];
		}
		for (int j = i; j < this.len; j++)
			this.value[str.length() + j] = temp[j];
		for (int j = 0; j < str.length(); j++)
			this.value[i + j] = str.charAt(j);
		this.len += str.length();
		return this;
	}

	// 向指定位置插入布尔类型变量
	public synchronized MyStringBuffer insert(int i, boolean b) {
		return this.insert(i, b ? "true" : "false");
	}

	// 将指定字符串添加到变量字符串的尾部
	public synchronized MyStringBuffer append(String str) {
		return this.insert(this.len, (str == null) ? "null" : str);
	}

	// 将begin到end-1的的子串删除
	public synchronized MyStringBuffer delete(int begin, int end) {
		if (begin < 0)// 序号容错
			begin = 0;// 从串首开始删除
		if (end > this.len)
			end = this.len;// 删除至串尾的子串
		if (begin > end)
			throw new StringIndexOutOfBoundsException(begin - end);
		// 从end开始至串尾的子串向前移动
		for (int i = 0; i < this.len - end; i++)
			this.value[begin + i] = this.value[end + i];
		this.len -= end - begin;
		return this;
	}
}