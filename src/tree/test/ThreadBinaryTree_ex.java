package tree.test;

import tree.ThreadBinaryTree;

/**
 *
 * 构造中序线索二叉树并进行中跟和先跟次序遍历
 */
public class ThreadBinaryTree_ex {

	public static void main(String[] args) {
		String[] prelist = { "A", "B", "D", null, null, "E", "G", null, null,
				null, "C", "F", null, "H", null, null, "K" };
		ThreadBinaryTree<String> tbitree = new ThreadBinaryTree<String>(prelist);
        tbitree.inOrder();//中跟遍历
        tbitree.preOrder();//先跟遍历
    }
}
