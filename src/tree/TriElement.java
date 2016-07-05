package tree;

/**
 * 二叉树的三叉链表结点类
 */
public class TriElement {

	int data;// 数据域,表示权值
	int parent, left, right;// 父母节点和左,右孩子结点下标

	public TriElement(int data, int parent, int left, int right) {
		this.data = data;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}

	public TriElement(int data) {
		this(data, -1, -1, -1);
	}

	public TriElement() {
		this(0);
	}

	public String toString() {
		return "(" + this.data + ", " + this.parent + ", " + this.left + ", "
				+ this.right + ")";
	}
}
