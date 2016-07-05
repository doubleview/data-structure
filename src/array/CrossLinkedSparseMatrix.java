package array;

/**
 * 十字链表存储的系数矩阵类
 */
public class CrossLinkedSparseMatrix {

	private int rows, columns;// 矩阵的行数和列数
	private CrossNode[] rowheads, columnshead;// 行指针数组和列指针数组，元素类型是十字链表节点

	
	
	//
	public CrossLinkedSparseMatrix(int rows, int columns) {// 构造rows行columns列零矩阵
		if (rows <= 0 || columns <= 0)
			throw new IllegalArgumentException("矩阵行数或列数非正数");
		this.rows = rows;
		this.columns = columns;
		this.rowheads = new CrossNode[this.rows];// 构造行指针数组的空顺序表，元素是nul
		this.columnshead = new CrossNode[this.columns];// 构造列指针数组的空顺序表，元素是null
	}

	public CrossLinkedSparseMatrix(int rows, int columns, Triple[] elems) {
		this(rows, columns);
		for (int i = 0; i < elems.length; i++) {
			this.set(elems[i].row, elems[i].column, elems[i].value);
		}
	}

	// 返回矩阵第i行第j列的元素
	public int get(int i, int j) {
		if (i < 0 || i >= this.rows || j < 0 || j >= this.columns)
			throw new IndexOutOfBoundsException("矩阵元素的行或列越界");
		CrossNode p = this.rowheads[i];// 获得第i行单链表
		while (p != null) {// 在排序单链表中顺序查找
			if (p.data.column == j)// 查找到结点
				return p.data.value;
			p = p.right;

		}
		return 0;// 没有找到则返回0
	}

	// 以三元组设置矩阵元素
	public void set(Triple elem) {
		this.set(elem.row, elem.column, elem.value);
	}

	// 设置矩阵第row行第column列元素值为value
	public void set(int row, int column, int value) {
		if (value == 0)
			return;
		if (rows >= this.rows || column >= this.columns)
			throw new IllegalArgumentException("三元组的行或列序号越界");
		// 以下在第row条单链表中查找指定三元组，或更改，或在行，列单链表中插入到三元组的结点
		Triple elem = new Triple(row, column, value);
		CrossNode rhead = this.rowheads[row];// rhead指向第row行单链表的第一个结点
		if (rhead == null || rhead.data.column > column) {
			this.rowheads[row] = new CrossNode(elem, rhead, null);
			insertColumnHead(this.rowheads[row]);// 将该节点插入到列的单链表
			return;
		}
		CrossNode front = null, p = rhead;
		while (p != null && p.data.column <= column) {// 在拍下与单链表中顺序查找
			if (p.data.column == column) {// 查找到，更改矩阵元素值
				p.data.value = value;
				return;
			}
			front = p;// front是p的前驱结点
			p = p.right;
		}
		front.right = new CrossNode(elem, p, null);// 在fornt之后插入三元组结点，中间或尾插入
		insertColumnHead(front.right);// 将该结点插入到列的单链表
	}

	// 插入node节点到相应列的链表中
	private void insertColumnHead(CrossNode node) {
		Triple elem = node.data;
		CrossNode chead = this.columnshead[elem.column];// 获得第column列单链表
		if (chead == null || chead.data.row > elem.row) {// 空表插入或头插入
			this.columnshead[elem.column] = node;
			if (chead != null)
				node.down = chead.down;
		} else {// 中间插入或尾插入
			CrossNode front = chead, p = front.down;// front是p的前驱及结点
			while (p != null && p.data.row <= elem.row) {// 在排序单链表顺序查找
				front = p;
				p = p.down;
			}
			front.down = node;// 将node结点插入到front之后，中间或尾插入
			node.down = p;
		}
	}

	// 当前矩阵与smat矩阵相加，this+=smat
	public void add(CrossLinkedSparseMatrix smat) {
		if (this.rows != smat.rows || this.columns != smat.columns)
			throw new IllegalArgumentException("两个阶数不同，不能相加");
		for (int i = 0; i < this.rows; i++) {// 相加并合并两条排序单链表
			CrossNode rhead = this.rowheads[i];// 获取当前矩阵第i行单链表
			CrossNode q = smat.rowheads[i];// 获得参数矩阵第i行单链表
			if (q == null)
				continue;
			if (rhead == null || rhead.data.column > q.data.column) {// 空表或头插入
				rhead = new CrossNode(new Triple(q.data), rhead, null);
				this.rowheads[i] = rhead;
				insertColumnHead(rhead);
				q = q.right;
			}
			CrossNode front = null, p = rhead;// 中间或尾插入
			while (p != null && q != null) {
				if (p.data.column == q.data.column) {// 两个结点表示相同的位置
					p.data.value += q.data.value;// 更改元素值，矩阵元素值相加
					if (p.data.value == 0)// 相加元素值为0
						if (front == null) {
							this.rowheads[i] = p.right;
							removeColumnHeads(p);// 在相应的单链表中删除node结点
							p = p.right;
						} else {
							front.right = p.right;// 相加后元素不需要存储，删除p结点
							removeColumnHeads(p);// 在相应列的单链表中删除node结点
							p = front.right;
						}
					else {
						front = p;// front是p的前驱结点
						p = p.right;
					}
					q = q.right;
				} else if (p.data.column < q.data.column) {
					front = p;
					p = p.right;// 当前矩阵元素值小，p向后移动，赋值元素
				} else {
					// 赋值q结点并插入到front结点之后，赋值元素
					front.right = new CrossNode(new Triple(q.data), p, null);
					q = q.right;
					insertColumnHead(front.right);
				}
			}

			while (q != null) {// 将smat矩阵单链表中剩余结点复制并插入到当前链表尾
				front.right = new CrossNode(new Triple(q.data), null, null);
				insertColumnHead(front.right);
				front = front.right;
				q = q.right;
			}
		}

	}

	// 在相应列的单链表中删除node节点
	private void removeColumnHeads(CrossNode node) {
		Triple elem = node.data;
		CrossNode chead = this.columnshead[elem.column];// 获得第column列单链表
		if (chead.data.row == elem.row) {// 头删除，有chead!=null
			this.columnshead[elem.column] = node.down;// 删除头结点
		} else {
			CrossNode front = chead, p = front.down;// front是p的前驱结点
			while (p != null && p.data.row < elem.row) {// 在排序单链表中顺序查找
				front = p;
				p = p.down;
			}
			if (p != null && p.data.row == elem.row)// p为查找到结点
				front.down = node.down;// 删除front之后的node结点，中间或尾删除
		}
	}
}