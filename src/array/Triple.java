package array;

import list.Addible;

/**
 * 稀疏矩阵非零元素的三元组类
 */
public class Triple implements Comparable<Triple>, Addible<Triple> {

	int row, column, value;// 行号，列号，元素值，默认访问权限

	//以行号，列号以及值构造三元组
	public Triple(int row, int column, int value) {
		super();
		if (row < 0 || column < 0)
			throw new IllegalArgumentException("稀疏矩阵元素三元组的行/列序号非正数");
		this.row = row;
		this.column = column;
		this.value = value;
	}

	// 拷贝构造方法，赋值一个三元组
	public Triple(Triple elem) {
		this(elem.row, elem.column, elem.value);
	}

	// 返回三元组描述字符串
	public String toString() {
		return "(" + row + "," + column + "," + value + ")";
	}

	@Override
	// 根据三元组位置比较两个三元组的大小，与元素值无关，约定三元组排序次序
	public int compareTo(Triple elem) {
		if (this.row < elem.row || this.row == elem.row
				&& this.column < elem.column)
			return -1;
		if (this.row == elem.row && this.column == elem.column)
			return 0;
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Triple))
			return false;
		Triple elem = (Triple) obj;
		return this.row == elem.row && this.column == elem.column
				&& this.value == elem.value;
	}

	@Override
	// 两个三元组相加
	public void add(Triple term) {
		if (this.compareTo(term) == 0)
			this.value += term.value;
		else
			throw new IllegalArgumentException("两项的指数不同,不能相加");
	}

	@Override
	// 约定删除条件，不存储值为0的元素
	public boolean removeable() {
		return this.value == 0;
	}
}
