package tree;

/**
 * 以标明空子树的先跟序列构造二叉树
 */
public class TriBinaryTree<T> implements BinaryTTree<T> {

	public TriNode<T> root;// 根节点
	private int i;

	//
	public TriBinaryTree() {
		this.root = null;
	}

	// 以表明空子树的先跟序列构造一颗二叉树
	public TriBinaryTree(T[] prelist) {
		this.root = create(prelist, 1, null);
	}

	// 以表明空子树的先跟序列构造一颗子二叉树,子树的根植是prelist[i],层次为level
	// parent指向父母节点,返回所创建子树的根节点
	private TriNode<T> create(T[] prelist, int level, TriNode<T> parent) {
		TriNode<T> p = null;
		if (i < prelist.length) {
			T elem = prelist[i++];
			if (elem != null) {
				p = new TriNode<T>(elem, parent, null, null, level);
				p.left = create(prelist, level + 1, p);
				p.right = create(prelist, level + 1, p);
			}
		}
		return p;
	}

	// 设置以p节点（层次为level）为跟的子树中所有节点的层次
	public void setLevel(TriNode<T> p, int level) {
		if (p != null) {
			p.level = level;
			setLevel(p.left, level + 1);
			setLevel(p.right, level + 1);
		}
	}

	// 判断树是否为空
	public boolean isEmpty() {
		return this.root == null;
	}

	// 计算节点的个数
	public int count() {
		return count(root);
	}

	public int count(TriNode<T> p) {
		if (p == null)
			return 0;
		return 1 + count(p.left) + count(p.right);
	}

	// 返回树的高度
	public int height() {
		return height(root);
	}

	public int height(TriNode<T> p) {
		if (p == null)
			return 0;
		int lh = height(p.left);
		int rh = height(p.right);
		return lh >= rh ? lh + 1 : rh + 1;
	}

	@Override
	public void preOrder() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void inOrder() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void postOrder() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void levelOrder() {
		// TODO 自动生成的方法存根

	}

	@Override
	public BinaryNode<T> search(T key) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public BinaryNode<T> getParent(BinaryNode<T> node) {
		// TODO 自动生成的方法存根
		return null;
	}

	// 插入元素x作为根节点,原根节点作为其左孩子
	public void insertRoot(T x) {
		this.root = new TriNode<T>(x, null, this.root, null, 1);
		if (this.root.left != null)
			this.root.left.parent = this.root;
		setLevel(this.root.left, 2);// 设置原根结点为跟的子树中所有结点的层次
	}

	// 插入元素x作为p节点的左孩子,若leftChild为true,插入节点作为左孩子,否则作为其右孩子
	public TriNode<T> insertChild(TriNode<T> p, T x, boolean leftChild) {
		if (p == null || x == null)
			return null;
		TriNode<T> q = null;
		if (leftChild) {// 插入x节点作为p的左孩子,p原左孩子成为x的左孩子
			q = new TriNode<T>(x, p, p.left, null, p.level + 1);
			if (p.left != null)
				p.left.parent = q;// 原p左孩子节点的新父母节点是q
			p.left = q;
		} else {// 插入节点x节点作为p的右孩子,p的原右孩子成为x的右孩子
			q = new TriNode<T>(x, p, null, p.right, p.level + 1);
			if (p.right != null)
				p.right.parent = q;// 原p右孩子节点的新父母节点是q
			p.right = q;
		}
		setLevel(q, p.level + 1);// 设置以插入节点为跟的子树中所有节点的层次
		return q;// 返回插入节点
	}

	@Override
	public BinaryNode<T> insertChild(BinaryNode<T> node, T x, boolean leftChild) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void removeChild(BinaryNode<T> p, boolean leftChild) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void removeAll() {
		// TODO 自动生成的方法存根

	}

	private TriNode<T> deep;// 私有变量,以下两方法公用

	// 输出二叉树一条直径的路径
	public void printDiameter() {
		deep = this.root;
		String path = ")";
		deepest(this.root);
		while (deep != root) {
			path = "," + deep.data.toString() + path;
			deep = deep.parent;
		}
		if (this.root != null)
			path = deep.data.toString() + path;
		System.out.println("二叉树的直径(从跟到最深叶子节点) : (" + path);
	}

	// 在以p为跟的子树中寻找最深叶子节点,由deep指向首次出现的最深叶子节点
	private void deepest(TriNode<T> p) {
		if (p != null) {
			if (p.level > deep.level)
				deep = p;
			deepest(p.left);
			deepest(p.right);
		}
	}
}