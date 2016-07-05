package tree;

/**
 * 树类，泛型T指定结点的元素类型
 *
 */

public class Tree<T> implements TTree<T> {

	public TreeNode<T> root;// 根节点,节点结构是树的孩子兄弟链表

	@Override
	public boolean isEmpty() {
		return this.root == null;
	}

	@Override
	public TreeNode<T> getChild(TreeNode<T> p, int i) {
		// TODO 自动生成的方法存根
		return null;
	}

	// 返回p节点的最后一个孩子
	public TreeNode<T> getLastChild(TreeNode<T> p) {
		if (p == null || p.child == null)// p没有孩子
			return null;
		p = p.child;
		while (p.sibling != null)
			// p沿着兄弟链到达最后一个兄弟节点
			p = p.sibling;
		return p;
	}

	// 返回p节点的最后一个兄弟
	public TreeNode<T> getLastSibling(TreeNode<T> p) {
		if (p == null || p.sibling == null)
			return null;
		while (p.sibling != null)
			// p沿着兄弟链到达最后一个兄弟节点
			p = p.sibling;
		return p;
	}

	@Override
	public TreeNode<T> getParent(TreeNode<T> node) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	// 返回树的结点个数
	public int count() {
		return count(root);
	}

	// 返回以结点p为跟的子树的节点个数
	public int count(TreeNode<T> p) {
		if (p == null)
			return 0;
		return 1 + count(p.child) + count(p.sibling);
	}

	@Override
	public int childCount(T p) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int height() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public TreeNode<T> search(T x) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void preOrder() {
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

	// 插入根节点
	public void insertRoot(T x) {
		this.root = new TreeNode<T>(x, this.root, null);
	}

	// 插入兄弟节点
	public TreeNode<T> insertLastSibling(TreeNode<T> p, T x) {
		if (p == null)
			return null;
		while (p.sibling != null)
			// p沿着兄弟链到达最后一个节点
			p = p.sibling;
		p.sibling = new TreeNode<T>(x);// 插入最后一个节点
		return p.sibling;
	}

	// 插入孩子节点
	public TreeNode<T> insertLastChild(TreeNode<T> p, T x) {
		if (p == null)
			return null;
		if (p.child == null) {
			p.child = new TreeNode<T>(x);
			return p.child;
		} else
			return insertLastSibling(p.child, x);
	}

	// 先跟次序遍历树并返回树的横向凹入表示字符串
	public String toString() {
		return toString(root, "");
	}

	// 先跟次序遍历以p为跟的子树,tab参数指定缩进量,返回子树的横向凹入表示串
	public String toString(TreeNode<T> p, String tab) {
		if (p == null)
			return "";
		return tab + p.data.toString() + "\n" + toString(p.child, tab + "\t")
				+ toString(p.sibling, tab);
	}

	// 返回树或森林的广义表表示字符串
	public String toGenListString() {
		return toGenListString(this.root);
	}

	// 返回以p节点为跟的子树的广义表表示
	public String toGenListString(TreeNode<T> p) {
		if (p == null)
			return "";// 返回空子树表示
		String str = p.data.toString();
		if (p.child != null)
			str += "(" + toGenListString(p.child) + ")";
		if (p.sibling != null)
			str += "," + toGenListString(p.sibling);
		return str;
	}
}