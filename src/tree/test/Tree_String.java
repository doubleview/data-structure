package tree.test;

import tree.Tree;
import tree.TreeNode;

/**
 * 以横向凹入表示的构造树或森林,prelist数组存储树或森林的横向凹入表示字符串序列
 */
public class Tree_String {

	public static void main(String[] args) {
        String[] prelist = {"中国", "\t北京", "\t上海", "\t江苏", "\t\t南京",
                "\t\t\t江宁", "\t\t苏州", "\t\t无锡", "\t\t\t锡山", "\t浙江", "\t\t杭州",
                "\t\t宁波", "\t\t温州", "\t广东", "\t\t广州", "韩国", "\t首尔", "美国",
                "\t华盛顿", "\t纽约"};
        Tree<String> tree = create(prelist);
		System.out.println(tree.toString());
	}

	public static Tree<String> create(String prelist[]) {
        Tree<String> tree = new Tree<String>();// 创建空树
        if (prelist != null && prelist.length != 0) {
            tree.root = new TreeNode<String>(prelist[0]);// 创建根节点
            for (int i = 1; i < prelist.length; i++)
                insert(tree, prelist[i]);// 将值为prelist[i]结点插入到tree森林的最后一颗树中
        }
		return tree;
	}

	public static void insert(Tree<String> tree, String str) {
        TreeNode<String> p = tree.getLastSibling(tree.root);// p指向跟的最后一个兄弟
        if (p == null)
            p = tree.root;// p没有兄弟时指向跟，选择森林中最后一棵树
        if (str.charAt(0) != '\t')
			tree.insertLastSibling(p, str);
		else {
			str = str.substring(1);
			while (str.charAt(0) == '\t') {
				TreeNode<String> lastChild = tree.getLastChild(p);
				if (lastChild != null)
					p = lastChild;
				str = str.substring(1);
			}
            tree.insertLastChild(p, str);// 插入str作为p的最后一个孩子
        }
	}
}