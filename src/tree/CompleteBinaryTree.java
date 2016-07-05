package tree;

/**
 * 
 * 二叉树表表示的完全二叉树类，继承二叉树类
 */

public class CompleteBinaryTree<T> extends BinaryTree<T> {

	// 构造空二叉树
	public CompleteBinaryTree() {
		super();
	}

	// 以完全二叉树的层次序列构造完全二叉树,levellist指定层次序列
	public CompleteBinaryTree(T[] levellist) {
		this.root = create(levellist, 0);
	}

	// 创建以levellist[i]为跟的一颗子完全二叉树,返回所创建子树的根节点
	public BinaryNode<T> create(T[] levellist, int i) {
		BinaryNode<T> p = null;
		if (i < levellist.length) {
			p = new BinaryNode<T>(levellist[i]);
			p.left = create(levellist, 2 * i + 1);
			p.right = create(levellist, 2 * i + 2);
		}
		return p;
	}
}
