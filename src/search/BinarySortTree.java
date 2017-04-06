package search;

import tree.BinaryNode;
import tree.BinaryTree;

/**
 * 二叉排序树 */
public class BinarySortTree<T extends Comparable<T>> extends BinaryTree<T> {

	// 构造空二叉排序树
	public BinarySortTree() {
		super();
	}

	// 将values数组元素依次插入构造一颗二叉排序树
	public BinarySortTree(T[] values) {
		super();
		for (int i = 0; i < values.length; i++) {
			this.insert(values[i]);
		}
	}

	// 查找并返回首次出现的关键字为key的元素节点，若查找不成功，则返回null，非递归算法
	public BinaryNode<T> search(T key) {
		if (key == null)
			return null;
		BinaryNode<T> p = this.root;
		while (p != null && p.data.compareTo(key) != 0)
			// 当没有相等者
			if (p.data.compareTo(key) > 0)// 若key较小
				p = p.left;// 进入左子树
			else
				p = p.right;// 进入右子树
		return p;
	}

	// 插入元素x节点，不插入关键字重复元素和空元素
	public void insert(T x) {
		if (x == null)// 不能插入空对象
			return;
		if (root == null)// 建立根节点
			root = new BinaryNode<T>(x);
		else { // 插入x到以root为跟的二叉排序树中
			BinaryNode<T> p = this.root, parent = null;
			while (p != null) {
				parent = p;
				if (x.compareTo(p.data) == 0)// 不插入重复关键字重复的元素
					return;
				if (x.compareTo(p.data) < 0)
					p = p.left;
				else
					p = p.right;
			}
			p = new BinaryNode<T>(x);// 建立叶子节点
			if (x.compareTo(parent.data) < 0)// p作为parent的左孩子
				parent.left = p;
			else
				parent.right = p;// p作为p的右孩子

		}
	}

	// 删除元素为x的节点。返回删除节点，若没有删除返回null
	public BinaryNode<T> remove(T x) {
		if (root == null || x == null)
			return null;
		return remove(x, root, null);
	}

	// 再以p为跟的子树中删除元素为x的节点，parent是p的父母节点，返回删除节点，递归算法
	private BinaryNode<T> remove(T x, BinaryNode<T> p, BinaryNode<T> parent) {
		if (p == null)
			return null;
		if (x.compareTo(p.data) < 0)
			return remove(x, p.left, p);// 在p的左子树删除x，递归调用
		if (x.compareTo(p.data) > 0)
			return remove(x, p.right, p);// 在p的右子树中删除x，递归调用

		if (p.left != null && p.right != null) {// 找到待删除结点p，p是2度结点
			BinaryNode<T> insucc = p.right;// 寻找p在中跟次序下的后继结点insucc
			while (insucc.left != null)
				insucc = insucc.left;
			p.data = insucc.data;// 以后继结点值替换
			return remove(p.data, p.right, p);
		}

		if (parent == null) {// p是1度或叶子结点
			if (p.left != null)
				root = p.left;
			else
				root = p.right;
			return p;// 返回删除结点p
		}

		if (p == parent.left) {
			// p是1度或叶子结点，p是parent的左孩子
			if (p.left != null)
				parent.left = p.left;
			else
				parent.left = p.right;
		} else {// p是parent的右孩子
			if (p.left != null)
				parent.right = p.left;
			else
				parent.right = p.right;
		}
		return p;
	}
}