package tree.test;

import tree.BinaryNode;
import tree.BinaryTree;

/**
 *
 * 输出二叉树中指定结点的所有祖先结点
 */
public class Ancestors {

	public static void main(String[] args) {
		String[] prelist = { "A", "B", "D", null, "G", null, null, null, "C",
				"E", null, null, "F", "H" };
		BinaryTree<String> bitree = new BinaryTree<String>(prelist);

        bitree.preOrder();//先跟遍历
        bitree.inOrder();//中跟遍历
        bitree.postOrder();//后跟遍历

        System.out.println("节点个数是 " + bitree.count() + "   高度是 " + bitree.height());
        String value = "H";
		BinaryNode<String> find = bitree.search(value);
		if (find == null)
            System.out.println("未找到" + value);
        else {
			BinaryNode<String> parent = bitree.getParent(find);
            System.out.println(find.data + "的祖先是");
            while (parent != null) {
				System.out.print(parent.data + "  ");
				parent = bitree.getParent(parent);
			}
			System.out.println();
		}
	}
}