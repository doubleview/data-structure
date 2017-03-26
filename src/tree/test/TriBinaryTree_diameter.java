package tree.test;

import tree.TriBinaryTree;

/**
 * 三叉链表的输出直径测试
 */
public class TriBinaryTree_diameter {

	public static void main(String[] args) {
		String[] prelist = { "A", "B", "D", null, "G", null, null, null, "C",
				"E", null, null, "F", "H" };
		TriBinaryTree<String> bitree = new TriBinaryTree<>(prelist);
		bitree.preOrder();
        bitree.printDiameter();// 输出二叉树的直径
    }
}
