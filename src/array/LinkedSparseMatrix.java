package array;

import list.*;

/**
 * 三元组行的单链表存储的系数矩阵类
 */
public class LinkedSparseMatrix {

	private int rows, columns;// 矩阵行数和列数
	private SeqList<PolySLinkedList<Triple>> list;// 行指针顺序表,元素是多项式排序单链表

	// 构造rows行和columns列的零矩阵
	public LinkedSparseMatrix(int rows, int columns) {
		if (rows <= 0 || columns <= 0)
			throw new IllegalArgumentException("矩阵行数或列数非正数");
		this.rows = rows;
		this.columns = columns;
		this.list = new SeqList<PolySLinkedList<Triple>>();// 构造空顺序表，元素是null
		for (int i = 0; i < rows; i++)
			// 增加rows个空单链表
			this.list.append(new PolySLinkedList<Triple>());
	}

	// 深拷贝
	public LinkedSparseMatrix(LinkedSparseMatrix smat) {
		this(smat.rows, smat.columns);
		for (int i = 0; i < this.rows; i++) {
			// 多项式单链表深拷贝，已复制所有节点，没有复制元素对象
			PolySLinkedList<Triple> link = new PolySLinkedList<Triple>(
					smat.list.get(i));
			Node<Triple> p = link.head.next;
			while (p != null) {
				p.data = new Triple(p.data);// 复制元素对象
				p = p.next;
			}
			this.list.set(i, link);// 将复制后的单链表设置为顺序表第i个元素
		}
	}

	// 返回矩阵第i行第j列的元素
	public int get(int i, int j) {
		if (i < 0 || i >= rows || j < 0 || j >= columns)
			throw new IndexOutOfBoundsException("矩阵元素的行或列序号越界");
		PolySLinkedList<Triple> link = this.list.get(i);// 获得第i行多项式排序单链表
		Triple find = link.search(new Triple(i, j, 0));// 在排序单链表中顺序查找，返回找到结点
		return (find == null) ? 0 : find.value;// 没有找到时返回0.否则返回结点元素
	}

	// 以三元组设置矩阵元素
	public void set(Triple elem) {
		this.set(elem.row, elem.column, elem.value);
	}

	// 设置矩阵第row行第column列元素为value
	public void set(int row, int column, int value) {
		if (value == 0)
			return;// 不存储值为0元素
		if (row >= this.rows || columns >= this.columns)
			throw new IllegalArgumentException("三元组的行或列序号越界");
		PolySLinkedList<Triple> link = this.list.get(row);// 获得第row行多项式排序单链表
		Node<Triple> front = link.head, p = front.next;
		while (p != null && p.data.column <= column) {// 在排序单链表中进行顺序查找
			if (p.data.column == column) {// 查找到，更改矩阵元素值
				p.data.value = value;
				return;
			}
			front = p;
			p = p.next;
		}
		front.next = new Node<Triple>(new Triple(row, column, value), p);// 在front之后插入三元组元素
	}

	// 返回稀疏矩阵三元组行的单链表和稀疏矩阵描述字符串
	public String toString() {
		String str = "三元组行的单链表：\n";
		for (int i = 0; i < this.list.length(); i++) {
			str += this.list.get(i).toString() + "\n";
		}

		str += "稀疏矩阵" + this.getClass().getName() + "(" + rows + " : "
				+ columns + ")  :  \n";
		for (int i = 0; i < this.list.length(); i++) {
			SortedSinglyLinkedList<Triple> link = this.list.get(i);
			Node<Triple> p = link.head.next;
			for (int j = 0; j < this.columns; j++)
				if (p != null && j == p.data.column) {
					str += String.format("%4d", p.data.value);
					p = p.next;
				} else
					str += String.format("%4d", 0);
			str += "\n";
		}
		return str;
	}

	// 当前矩阵与smat矩阵相加，this+=smat,改变当前矩阵
	public void add(LinkedSparseMatrix smat) {
		if (this.rows != smat.rows || this.columns != smat.columns)
			throw new IllegalArgumentException("两个矩阵结束不同，不能相加");
		for (int i = 0; i < this.list.length(); i++) {
			this.list.get(i).add(smat.list.get(i));// 调用多项式单链表相加(+=)算法
		}
	}

	// 返回当前矩阵与smat相加后的矩阵，不改变当前矩阵，smatc=this+smat
	public LinkedSparseMatrix plus(LinkedSparseMatrix smat) {
		LinkedSparseMatrix smatc = new LinkedSparseMatrix(this);// 深拷贝
		smatc.add(smat);
		return smatc;// 返回对象引用
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof LinkedSparseMatrix))
			return false;
		LinkedSparseMatrix smat = (LinkedSparseMatrix) obj;
		return this.rows == smat.rows && this.columns == smat.columns
				&& this.list.equals(smat.list);
	}
}