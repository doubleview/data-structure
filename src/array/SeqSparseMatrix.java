package array;

import list.SeqList;

/**
 * 稀疏矩阵三元组顺序表存储
 */
public class SeqSparseMatrix {

	private int rows, columns;// 存储行数和列数
	private SeqList<Triple> list;// 存储三元组的顺序表

	// 构造rows行columns列零矩阵
	public SeqSparseMatrix(int rows, int columns) {
		if (rows <= 0 || columns <= 0)
			// 抛出无效参数异常
			throw new IllegalArgumentException("矩阵行数或列数非正数");
		this.rows = rows;
		this.columns = columns;
		this.list = new SeqList<Triple>();
	}

	// 构造rows行colums列矩阵，由三元组elems提供矩阵初值
	public SeqSparseMatrix(int rows, int columns, Triple[] elems) {
		this(rows, columns);
		for (int i = 0; i < elems.length; i++) {
			// 按行插入一个元素的三元组
			this.set(elems[i]);
		}
	}

	// 得到第i行第j个数
	public int get(int i, int j) {
		if (i < 0 || i >= rows || j < 0 || j >= columns)
			throw new IndexOutOfBoundsException("矩阵元素的行或列序号越界");
		Triple item = new Triple(i, j, 0);
		int k = 0;
		Triple elem = this.list.get(k);
		// 在排序顺序表list中顺序查找item
		while (k < this.list.length() && item.compareTo(elem) >= 0) {
			if (item.compareTo(elem) == 0)// 只比较三元组元素位置
				return elem.value;// 查找到(i,j)，返回到矩阵元素
			k++;// item较大时向后走
			elem = this.list.get(k);
		}
		return 0;// 没有找到时返回0
	}

	// 以三元组设置矩阵元素
	public void set(Triple elem) {
		this.set(elem.row, elem.column, elem.value);
	}

	// 设置矩阵第row行第column列的元素值为value
	public void set(int row, int column, int value) {
		if (value == 0)
			return;// 不存储值为0元素
		if (row >= this.rows || column >= this.columns)
			throw new IllegalArgumentException("三元组的行或列序号越界");
		Triple elem = new Triple(row, column, value);
		int i = 0;
		// 在排序的三元组顺序表中查找elem对象，后更改或插入
		while (i < this.list.length()) {// 若elem存在，则更改位置矩阵元素
			Triple item = this.list.get(i);
			if (elem.compareTo(item) == 0) {
				this.list.set(i, elem);// 设置顺序表第i个元素为elem
				return;
			}
			if (elem.compareTo(item) >= 0)// elem较大时向后走
				i++;
			else
				break;
		}
		this.list.insert(i, elem);// 插入elem对象作为顺序表第i个元素
	}

	// 返回稀疏矩阵三元组顺序表和稀疏矩阵描述字符串
	public String toString() {
		String str = "三元组顺序表：" + this.list.toString() + "\n";
		str += "稀疏矩阵 " + this.getClass().getName() + "(" + rows + ":" + columns
				+ ")  :  \n";
		int k = 0;
		Triple elem = this.list.get(k++);// 返回第k个元素，若k指定序号无效则返回null
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				if (elem != null && i == elem.row && j == elem.column) {
					str += String.format("%4d", elem.value);
					elem = this.list.get(k++);
				} else
					str += String.format("%4d", 0);
			}
			str += "\n";
		}
		return str;
	}

	// 将两个稀疏矩阵相加
	public SeqSparseMatrix plus(SeqSparseMatrix smat) {
		if (this.rows != smat.rows || this.columns != smat.columns)
			throw new IllegalArgumentException("两个矩阵结束不同，不能相加");
		// 构造零矩阵
		SeqSparseMatrix smatc = new SeqSparseMatrix(this.rows, this.columns);
		int i = 0, j = 0;
		// 分别遍历两个矩阵的顺序表
		while (i < this.list.length() && j < smat.list.length()) {
			Triple elema = this.list.get(i);
			Triple elemb = smat.list.get(j);
			if (elema.compareTo(elemb) == 0) {
				// 若两个三元组相同位置的矩阵元素，则对应元素值相加
				if (elema.value + elemb.value != 0)
					smatc.list.append(new Triple(elema.row, elema.column,
							elema.value + elemb.value));
				i++;
				j++;
			} else if (elema.compareTo(elemb) < 0) {// 将较小三元组复制到smatc顺序表最后
				smatc.list.append(new Triple(elema));// 复制elema元素执行Triple拷贝构造方法
				i++;
			} else {
				smatc.list.append(new Triple(elemb));
				j++;
			}
		}
		// 将当前元素
		while (i < this.list.length())
			smatc.list.append(new Triple(this.list.get(i++)));
		while (j < smat.list.length())
			smatc.list.append(new Triple(smat.list.get(j++)));
		return smatc;// 返回对象的引用
	}
}