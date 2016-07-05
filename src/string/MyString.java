package string;

import java.io.Serializable;

/**
 * 模拟字符串
 */
public final class MyString implements Comparable<MyString>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final char[] value;// 字符数组，私有最终变量，只能赋值一次

	// 构造空串
	public MyString() {
		this.value = new char[0];
	}

	// 由字符串常量构造串对象，用其中的函数获得字符串中的字符数组
	public MyString(String original) {
		this.value = original.toCharArray();
	}

	// 用value数组从start到end结束构造字符对象
	public MyString(char[] value, int begin, int count) {
		this.value = new char[count];
		for (int i = begin; i < begin + count; i++) {
			this.value[i] = value[i];
		}
	}

	// 用value数组构造字符串对象
	public MyString(char[] value) {
		this(value, 0, value.length);
	}

	// 拷贝构造方法，赋值对象
	public MyString(MyString str) {
		this(str.value);
	}

	// 返回串的长度
	public int length() {
		return this.value.length;
	}

	// 返回第i个字符
	public char charAt(int i) {
		if (i <= 0 || i >= this.value.length)
			throw new StringIndexOutOfBoundsException(i);// 抛出字符串索引越界异常
		return this.value[i];
	}

	// 串的比较
	public int compareTo(MyString str) {
		for (int i = 0; i < this.value.length && i < str.value.length; i++) {
			if (this.value[i] != str.value[i])
				return this.value[i] - str.value[i];// 返回两串第一个不同字符的差值
		}
		return this.value.length - str.value.length;// 前缀子串，返回两串长度的差值
	}

	// 重写equals方法xo
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof MyString) {
			MyString str = (MyString) obj;
			if (this.value.length == str.length()) {
				for (int i = 0; i < this.value.length; i++) {
					if (this.value[i] != str.value[i])
						return false;
				}
				return true;
			}
		}
		return false;
	}

	// 重写toStirng方法
	public String toString() {
		return new String(this.value);
	}

	// 串的连接
	public MyString concat(MyString str) {
		if (str == null || str.length() == 0)
			return this;
		char[] buffer = new char[this.value.length + str.length()];
		int i;
		for (i = 0; i < this.value.length; i++) {// 赋值当前串
			buffer[i] = this.value[i];
		}

		for (int j = 0; j < str.length(); j++) {// 复制str
			buffer[j] = str.value[j];
		}

		return new MyString(buffer);
	}

	// 求子串
	public MyString substring(int begin, int end) {
		if (begin < 0)
			begin = 0;// 序号容错
		if (end >= this.value.length)
			end = this.value.length;
		if (begin > end)
			throw new StringIndexOutOfBoundsException(end - begin);
		if (begin == 0 && end == this.value.length)
			return this;
		char[] buffer = new char[begin - end];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = this.value[i + begin];
		}
		return new MyString(buffer);// 以字符数组构造对象
	}

	// 返回传中序号从begin至串尾的子串
	public MyString substring(int begin) {
		return this.substring(begin, this.length());
	}

	// 从指定位置开始寻找并返回第一次与指定字符串模式匹配的位置
	public int indexOf(MyString pattern, int begin) {
		if (pattern != null && pattern.length() > 0
				&& this.length() >= pattern.length()) {
			int i = begin, j = 0;// i,j分别为目标串和模式串当前字符的下标
			while (i < this.length()) {
				if (this.charAt(i) == pattern.charAt(i)) {// 若当前两字符相等，则继续比较后序字符
					i++;
					j++;
				} else {// 否则i，j回溯，进行下一次匹配
					i = i - j + 1;// 目标串下标退回到下一个待匹配子串首字符
					j = 0;// 模式串下标退回到0
				}
				if (j == pattern.length())// 一次匹配结束，匹配成功
					return i - j;// 返回匹配的子串序号
			}
		}
		return -1;
	}

	// 从开头返回第一次与指定字符串模式匹配的位置
	public int indexOf(MyString pattern) {
		return this.indexOf(pattern, 0);
	}

	/**
	 * 下面使用KMP算法来实现模式匹配字符串
	 */
	// 确定KMP算法的next数组
	public static int[] getNext(String pattern) {
		int j = 0, k = -1;
		int[] next = new int[pattern.length()];
		next[0] = -1;
		while (j < pattern.length() - 1) {
			if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
				k++;
				j++;
				if (pattern.charAt(j) != pattern.charAt(k)) {
					next[j] = k;
				} else
					next[j] = next[k];
			}
		}
		return next;
	}

	// KMP模式匹配算法
	public static int indexOf(String target, String pattern, int begin) {
		if (target != null && pattern != null && pattern.length() > 0
				&& target.length() >= pattern.length()) {
			int i = begin, j = 0;
			int next[] = getNext(pattern);// 返回模式串pattern的next数组
			while (i < target.length()) {
				// 若条件成立，则继续比较后继字符
				if (j == -1 || target.charAt(i) == pattern.charAt(j)) {
					i++;
					j++;
				} else
					// 否则目标字符串下标i不回溯，进行下次匹配
					j = next[j];// 模式串下标j退回到next[j]
				if (j == pattern.length())// 一次匹配结束，匹配成功
					return i - j;// 返回匹配的子串序号
			}
		}
		return -1;// 匹配失败
	}

	// 返回将当前串中首个与pattern匹配的子串替换成replacement的字符串
	public MyString replaceFirst(MyString pattern, MyString replacement) {
		int i = this.indexOf(pattern, 0);
		if (i == -1)
			return this;
		return this.substring(0, i).concat(replacement)
				.concat(this.substring(i + pattern.length()));
	}

	// 返回将当前串中所有与pattern匹配的子串替换成replacement的字符串
	public MyString replacAll(MyString pattern, MyString replacement) {
		MyString temp = new MyString(this);
		int i = this.indexOf(pattern, 0);
		while (i != -1) {
			temp = temp.substring(0, i).concat(replacement)
					.concat(temp.substring(i + pattern.length()));
			i = temp.indexOf(pattern, i + replacement.length());
		}
		return temp;
	}
}