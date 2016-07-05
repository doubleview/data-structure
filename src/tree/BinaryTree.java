package tree;

import stackqueue.LinkedQueue;
import stackqueue.LinkedStack;

/**
 * 二叉树类，实现BinaryTree<T>接口，泛型T指定结点的元素类型
 */
public class BinaryTree<T> implements BinaryTTree<T> {

	public BinaryNode<T> root;// 根节点，结点结构为二叉链表

	private int i;// 作为create(T[] prelist)方法的成员变量使用

	public BinaryTree() {
		this.root = null;
	}

	// 以先跟序列和中跟序列构造二叉树
	public BinaryTree(T[] prelist, T[] inlist) {
		this.root = create(prelist, inlist, 0, 0, prelist.length);
	}

	// 以标明空子树的先跟序列构造一颗二叉树
	public BinaryTree(T[] prelist) {
		this.root = create(prelist);
	}

	// 以标明空子树的先跟序列构造一颗子二叉树,子树的跟值是prelist[i],返回所创建子树的根节点
	private BinaryNode<T> create(T[] prelist) {
		BinaryNode<T> p = null;
		if (i < prelist.length) {
			T elem = prelist[i];
			i++;
			if (elem != null) {// 不能elme="^"，因为T不一定是String
				p = new BinaryNode<T>(elem);// 创建叶子结点
				p.left = create(prelist);// 创建p的左子树
				p.right = create(prelist);// 创建p的右子树
			}
		}
		return p;
	}

	// 创建子树的根节点(以先跟序列和中跟序列构造二叉树)
	private BinaryNode<T> create(T[] prelist, T[] inlist, int preStart,
			int inStart, int n) {
		if (n <= 0)
			return null;
		BinaryNode<T> root = new BinaryNode<T>(prelist[preStart]);// 根结点值
		int i = inStart;
		while (i < n) {// 在中跟序列中查找跟值所在的位置
			if (prelist[preStart] == inlist[i]) {
				root.left = create(prelist, inlist, preStart + 1, inStart, i);// 创建左子树
				root.right = create(prelist, inlist, preStart + i + 1, inStart
						+ i + 1, n - i - 1);// 创建右子树
				break;
			}
			i++;
		}
		return root;
	}

	// 判断二叉树是否为空
	public boolean isEmpty() {
		return this.root == null;
	}

	// 判断二叉树的节点个数
	public int count() {
		return count(root);
	}

	// 返回以结点p为跟的子树的节点个数
	public int count(BinaryNode<T> p) {
		if (p == null)
			return 0;
		return 1 + count(p.left) + count(p.right);
	}

	// 返回二叉树的高度
	public int height() {
		return height(root);
	}

	// 返回以p结点为跟的子树高度，后跟次序遍历
	public int height(BinaryNode<T> p) {
		if (p == null)
			return 0;
		int lh = height(p.left);// 返回左子树的高度
		int rh = height(p.right);// 返回右子树的高度
		return lh >= rh ? lh + 1 : rh + 1;// 当前子树高度为较高子树的高度加1
	}

	// 先跟次序遍历二叉树
	public void preOrder() {
		System.out.print("先跟次序遍历二叉树  ");
		preOrder(root);// 调用先跟次序遍历二叉树的递归方法
		System.out.println();
	}

	// 先跟次序遍历以p结点为跟的子二叉树，递归方法
	public void preOrder(BinaryNode<T> p) {
		if (p != null) {// 若二叉树不为空
			System.out.print(p.data.toString() + " ");// 访问当前结点
			preOrder(p.left);// 按先跟次序遍历当前结点的左子树
			preOrder(p.right);// 按先跟次序遍历当前结点的右子树
		}
	}

	// 中跟遍历二叉树
	public void inOrder() {
		System.out.print("中跟次序遍历二叉树  ");
		inOrder(root);// 调用中跟次序遍历二叉树的递归方法
		System.out.println();
	}

	// 中跟次序遍历以p结点为跟的子二叉树，递归调用
	public void inOrder(BinaryNode<T> p) {
		if (p != null) {
			inOrder(p.left);// 中跟次序遍历左子树，递归调用
			System.out.print(p.data.toString() + " ");
			inOrder(p.right);// 中跟次序遍历右子树，递归调用
		}
	}

	// 后跟次序遍历二叉树
	public void postOrder() {
		System.out.print("后跟次序遍历二叉树  ");
		postOrder(root);// 调用后跟次序遍历二叉树的递归方法
		System.out.println();
	}

	// 后跟次序遍历以p结点为跟的子二叉树，递归调用
	public void postOrder(BinaryNode<T> p) {
		if (p != null) {
			postOrder(p.left);
			postOrder(p.right);
			System.out.print(p.data.toString() + " ");
		}
	}

	// 按层次遍历二叉树
	public void levelOrder() {
		LinkedQueue<BinaryNode<T>> que = new LinkedQueue<BinaryNode<T>>();
		BinaryNode<T> p = this.root;
		System.out.println("层次遍历：");
		while (p != null) {
			System.out.print(p.data + "");
			if (p.left != null)
				que.enquenu(p.left); // p的左孩子节点入队
			if (p.right != null)
				que.enquenu(p.right); // p的右孩子节点入队
			p = que.dequeue(); // p指向出对节点,若队列空返回null
		}
		System.out.println();
	}

	// 查找并返回首次出现关键字为key元素的节点
	public BinaryNode<T> search(T key) {
		return search(root, key);
	}

	// 在以p为跟的子树中查找并返回首次出现的关键字为key的元素结点，若未找到，则返回null
	public BinaryNode<T> search(BinaryNode<T> p, T key) {
		if (p == null || key == null)
			return null;
		if (p.data.equals(key))
			return p;// 查找成功，返回找到结点
		BinaryNode<T> find = search(p.left, key);// 在左子树中查找，递归调用
		if (find == null)// 若在左子树中未找到
			find = search(p.right, key);// 则继续在右子树中查找，递归调用
		return find;// 返回查找结果
	}

	// 返回node的父母节点
	public BinaryNode<T> getParent(BinaryNode<T> node) {
		if (root == null || node == root)
			return null;
		return getParent(root, node);
	}

	// 在以p为跟的子树中查找并返回node结点的父母结点
	public BinaryNode<T> getParent(BinaryNode<T> p, BinaryNode<T> node) {
		if (p == null)
			return null;
		if (p.left == node || p.right == node)
			return p;
		BinaryNode<T> find = getParent(p.left, node);
		if (find == null)
			find = getParent(p.right, node);
		return find;
	}

	// 返回二叉树的广义表表示字符串
	public String toGenListString() {
		return "二叉树的广义表表示:" + toGenListString(this.root) + "\n";
	}

	// 返回空子树表示
	public String toGenListString(BinaryNode<T> p) {
		if (p == null)
			return "^";// 返回空子树表示
		String str = p.data.toString();
		if (p.left != null || p.right != null)// 非叶结点，有子树
			str += "(" + toGenListString(p.left) + ","
					+ toGenListString(p.right) + ")";// 递归调用
		return str;
	}

	@Override
	// 插入元素x作为左孩子，否则作为右孩子
	public void insertRoot(T x) {
		root = new BinaryNode<T>(x, root, null);
	}

	@Override
	// 插入元素x作为p结点的孩子，若leftChild为true，插入结点作为左孩子，否则作为右孩子
	public BinaryNode<T> insertChild(BinaryNode<T> p, T x, boolean leftChild) {
		if (p == null || x == null)
			return null;
		if (leftChild) {
			// 插入x作为p的左孩子，p原左孩子成为x左孩子
			p.left = new BinaryNode<T>(x, p.left, null);
			return p.left;// 返回插入结点
		}
		p.right = new BinaryNode<T>(x, null, p.right);// 插入x结点作为p的右孩子
		return p.right;
	}

	@Override
	// 删除p节点的左或右子树,若leftChild为true,则删除左子树,否则删除右子树
	public void removeChild(BinaryNode<T> p, boolean leftChild) {
		if (p != null)
			if (leftChild)
				p.left = null;
			else
				p.right = null;
	}

	@Override
	// 删除二叉树
	public void removeAll() {
		this.root = null;
	}

	// 中跟次序遍历二叉树的非递归遍历
	public void inOrderTraverse() {
		System.out.print("中跟次序遍历（非遍历）");
		LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
		BinaryNode<T> p = this.root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);// p结点入栈
				p = p.left;// 进入左子树
			} else {// p为空且栈非空
				p = stack.pop();// p指向出栈结点
				System.out.println(p.data + " ");// 访问结点
				p = p.right;// 进入右子树
			}
		}
	}

	// 先跟次序遍历二叉树的非递归遍历
	public void preOrderTraverse() {
		System.out.println("先跟次序遍历(非递归)");
		LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
		BinaryNode<T> p = this.root;
		while (p != null || !stack.isEmpty())
			if (p != null) {
				System.out.println(p.data + " ");// 访问结点
				stack.push(p);// 将p入栈
				p = p.left;
			} else {
				p = stack.pop();
				p = p.right;
			}
	}
}