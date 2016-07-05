package tree;

/**
 * 中序线索二叉树类,泛型T指定节点的元素类型
 */
public class ThreadBinaryTree<T> {

	public ThreadNode<T> root;

	// 构造空中序线索二叉树
	public ThreadBinaryTree() {
		this.root = null;
	}

	// 以标明空子树的先跟序列构造二叉树并进行中序线索化
	public ThreadBinaryTree(T[] prelist) {
		this.root = create(prelist);
		inorderThread(this.root);
	}

	private int i;

	// 以标明空子树的先跟序列创建子树
	private ThreadNode<T> create(T[] prelist) {
		ThreadNode<T> p = null;
		if (i < prelist.length) {
			T elem = prelist[i];
			i++;
			if (elem != null) {// 不能elem="^",因为T不一定是String
				p = new ThreadNode<T>(elem);// 创建叶子节点
				p.left = create(prelist);// 创建p的左子树
				p.right = create(prelist);// 创建p的右子树
			}
		}
		return p;
	}

	// 判断中序线索二叉树是否为空
	public boolean isEmpty() {
		return this.root == null;
	}

	private ThreadNode<T> front = null;

	// 中序线索化以p节点为跟的子树,p的前驱节点是front
	private void inorderThread(ThreadNode<T> p) {
		if (p != null) {
			inorderThread(p.left);// 中序线索p的左子树
			if (p.left == null) {// 若p的左子树为空
				p.ltag = 1;// 设置左线索标记
				p.left = front;// 设置p的left为指向前驱front的线索
			}
			if (p.right == null)// 若p的right右子树为空
				p.rtag = 1;// 设置右线索标记

			if (front != null && front.rtag == 1)// 设置front.right为指向后继p的线索
				front.right = p;//
			front = p;
			inorderThread(p.right);// 中序线索化p的右子树
		}
	}

	// 返回p在中跟次序遍历下的后继节点
	public ThreadNode<T> inNext(ThreadNode<T> p) {
		if (p.rtag == 1)// 若右子树为空
			p = p.right;// p.right就是指向后继节点的线索
		else {
			p = p.right;
			while (p.ltag == 0)
				// 若右子树非空,进入右子树
				p = p.left;// 找到最左边的后代节点
		}
		return p;
	}

	// 返回p在中跟次序遍历下的前驱结点
	public ThreadNode<T> inPrevious(ThreadNode<T> p) {
		if (p.ltag == 1)// 若左子树为空
			p = p.left;// p.left就是指向前驱结点的线索
		else {
			p = p.left;
			while (p.rtag == 0)
				p = p.right;
		}
		return p;
	}

	// 中跟次序遍历中序线索二叉树,非递归算法
	public void inOrder() {
		System.out.print("中跟次序遍历中序线索二叉树");
		ThreadNode<T> p = this.root;
		while (p.ltag == 0)
			// 寻找跟的最左边的后代节点,即第一个访问的节点
			p = p.left;
		while (p != null) {
			System.out.print(p.data.toString() + " ");
			p = inNext(p);// 返回p在中跟次序下的后继结点
		}
		System.out.println();
	}

	// 返回p在先跟次序下的后继节点
	public ThreadNode<T> preNext(ThreadNode<T> p) {
		if (p.ltag == 0)// 若左子树非空
			p = p.left;// 左孩子就是p的后继节点
		else { // 否则,后继是右兄弟或某个中序祖先的右孩子
			while (p.rtag == 1 && p.right != null)
				// 寻找某个中序祖先
				p = p.right;// 后继是其某个中序祖先的右孩子
			p = p.right;// 右孩子是p的后继节点
		}
		return p;
	}

	// 先跟次序遍历线索二叉树,非递归算法
	public void preOrder() {
		System.out.print("先跟次序遍历中序线索二叉树,非递归");
		ThreadNode<T> p = this.root;
		while (p != null) {
			System.out.print(p.data.toString() + "");
			p = preNext(p); // 返回p在先跟次序下的后继结点
		}
		System.out.println();
	}

	// 返回p在后跟遍历次序下的前驱节点
	public ThreadNode<T> postNext(ThreadNode<T> p) {
		if (p.rtag == 0)
			p = p.right;
		else {
			while (p.ltag == 1 && p.left != null)
				p = p.left;
			p = p.left;
		}
		return p;
	}

	// 插入作为根结点
	public void insertRoot(T x) {
		if (this.root == null)
			this.root = new ThreadNode<T>(x, null, 1, null, 1);
		else {
			ThreadNode<T> p = this.root;
			while (p.rtag == 0)
				// 寻找原跟的最右子孙节点p,即最后访问结点
				p = p.right;
			this.root = new ThreadNode<T>(x, this.root, 0, null, 1);
			p.right = this.root;// 修改p的后继线索
		}
	}

	// 插入x作为p的孩子结点,若leftChild为true,插入左孩子,否则插入右孩子
	public ThreadNode<T> insertChild(ThreadNode<T> p, T x, boolean leftChild) {
		ThreadNode<T> q = null;
		if (leftChild) {// 插入左孩子
			q = new ThreadNode<T>(x, p.left, p.ltag, p, 1);
			p.left = q;
			p.ltag = 0;
			if (q.ltag == 0) {
				ThreadNode<T> prev = inPrevious(q);// prev是q在中跟次序下的前驱
				prev.right = q;
			}
		} else {
			q = new ThreadNode<T>(x, p, 1, p.right, p.rtag);
			p.right = q;
			p.rtag = 1;
			if (q.rtag == 0) {
				ThreadNode<T> succ = inNext(q);// succ是q在中跟次序下的后继
				succ.left = q;// 修改后继结点succ的后继
			}
		}

		return q;
	}

	// 删除右孩子结点
	public void removeRightChild(ThreadNode<T> p) {
		if (root == null || p == null || p.rtag == 1)
			return;
		ThreadNode<T> q = p.right;// q为待删除结点
		if (q.ltag == 0) {// q有左孩子
			p.right = q.left;// 用q的左孩子顶替q，p.rtag未变
			ThreadNode<T> prev = inPrevious(q);// prev指向q在中跟次序下的前驱
			prev.right = q.right;// 修改前驱结点prev的后继线索
			prev.rtag = q.rtag;
			if (q.rtag == 0)// q也有右孩子
				inNext(q).left = prev;// 修改q后继结点inNext(q)的前驱线索
		} else {
			p.right = q.right;// 用q的右孩子顶替q
			p.rtag = q.rtag;
			if (q.rtag == 0)// q有右孩子没有左孩子
				inNext(q).left = p;// 修改q的后继结点inNext(q)的前驱线索
		}
	}

	// 删除根结点,用左孩子顶替
	public void removeRoot() {
		if (root == null)// 若空树，则不删除
			return;
		ThreadNode<T> prev = inPrevious(root);// prev指向跟的前驱
		ThreadNode<T> succ = inNext(root);// succ指向跟的后继
		if (prev != null) {
			prev.right = root.right;// 使前驱prev的后继指向跟的右孩子
			prev.rtag = root.rtag;
		}
		if (succ != null) {// 跟有后继时
			succ.left = prev;// 修改后继succ的前驱线索，succ.rtag未变
		}
		if (root.ltag == 0)// 跟有左孩子时
			root = root.left;// 用左孩子顶替跟
		else
			root = root.right;// 用右孩子顶替跟
	}
}