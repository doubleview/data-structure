package tree;

/**
 * 
 * 树的孩子兄弟链表节点类，泛型T指定节点的元素类型
 */
public class TreeNode<T> {

	public T data;// 数据域
	public TreeNode<T> child, sibling;// 链，分别指向孩子，兄弟结点

	// 构造结点，参数分别指定元素，孩子和兄弟结点
	public TreeNode(T data, TreeNode<T> child, TreeNode<T> sibling) {
		super();
		this.data = data;
		this.child = child;
		this.sibling = sibling;
	}

	// 构造指定值的叶子结点
	public TreeNode(T data) {
		this(data, null, null);
	}

	public TreeNode() {
		this(null);
	}
}
