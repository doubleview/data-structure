package tree;

/**
 * 二叉树的三叉链表结点类，泛型E指定结点的元素类型
 */
public class TriNode<T> {

	public T data;// 数据域,存储数据元素
	public TriNode<T> parent, left, right;// 链,分别指向父母节点,右孩子与左孩子
	public int level;// 节点的层次

	// 构造结点，参数分别指定元素，父母结点，左和右孩子结点
	public TriNode(T data, TriNode<T> parent, TriNode<T> left,
			TriNode<T> right, int level) {
		super();
		this.data = data;
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.level = level;
	}

	// 构造指定的叶子节点
	public TriNode(T data) {
		this(data, null, null, null, 0);
	}

	public TriNode() {
		this(null, null, null, null, 0);
	}
}