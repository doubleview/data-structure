package tree;

/**
 * 二叉树接口，二叉树抽象数据类型
 */
public interface BinaryTTree<T> {

	boolean isEmpty();// 判断二叉树是否为空

	int count();// 判断二叉树的节点个数

	int height();// 返回二叉树的高度

	void preOrder();// 先跟次序遍历二叉树

	void inOrder();// 中跟遍历二叉树

	void postOrder();// 后跟次序遍历二叉树

	void levelOrder();// 按层次遍历二叉树

	BinaryNode<T> search(T key);// 查找并返回首次出现关键字为key元素的节点

	BinaryNode<T> getParent(BinaryNode<T> node);// 返回node的父母节点

	void insertRoot(T x);// 插入元素x作为根节点

	BinaryNode<T> insertChild(BinaryNode<T> node, T x, boolean leftChild);// 插入孩子节点

	void removeChild(BinaryNode<T> p, boolean leftChild);// 删除p节点的左或右子树

	void removeAll();// 删除二叉树
}
