package tree;

/**
 * 线索二叉树的二叉树表结点类，T指定结点的元素类型
 */
public class ThreadNode<T> {

	public T data;// 数据元素
	public ThreadNode<T> left, right;// 分贝指向左右孩子结点
	public int ltag, rtag;// 左右线索标记

	public ThreadNode(T data, ThreadNode<T> left, int ltag,
			ThreadNode<T> right, int rtag) {
		super();
		this.data = data;
		this.left = left;
		this.ltag = ltag;
		this.right = right;
		this.rtag = rtag;
	}

	// 构造指定值结点
	public ThreadNode(T data) {
		this(data, null, 0, null, 0);
	}

	public ThreadNode() {
		this(null, null, 0, null, 0);
	}
}
