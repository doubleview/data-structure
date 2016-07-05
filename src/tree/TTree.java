package tree;

/**
 * 树接口
 */
public interface TTree<T> {

	boolean isEmpty();// 判断是否空树

	TreeNode<T> getChild(TreeNode<T> p, int i);// 返回p节点的第i个孩子节点

	TreeNode<T> getLastChild(TreeNode<T> p);// 返回p节点的最后一个孩子节点

	TreeNode<T> getLastSibling(TreeNode<T> p);// 返回p节点的最后一个兄弟节点

	TreeNode<T> getParent(TreeNode<T> node);// 返回node节点的父母节点

	int count();// 返回树的节点个数

	int childCount(T p);// 返回p节点的孩子节点个数

	int height();// 返回树的高度

	TreeNode<T> search(T x);// 查找并返回元素为x的节点

	void preOrder();// 先跟次序遍历树

	void postOrder();// 后跟次序遍历树

	void levelOrder();// 中跟次序遍历树
}