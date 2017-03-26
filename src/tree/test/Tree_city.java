package tree.test;

import tree.Tree;
import tree.TreeNode;

/**
 * 构造一颗城市数或森林
 */
public class Tree_city {

	public static void main(String[] args) {
		Tree<String> tree = make();
		System.out.println(tree.toString());
	}

	public static Tree<String> make() {
		Tree<String> tree = new Tree<String>();
        tree.root = new TreeNode<String>("中国");
        tree.insertLastChild(tree.root, "北京市");
        tree.insertLastChild(tree.root, "上海市");
        TreeNode<String> js = tree.insertLastChild(tree.root, "江苏省");
        tree.insertLastChild(js, "南京市");
        tree.insertLastChild(js, "苏州市");
        TreeNode<String> zj = tree.insertLastSibling(js, "浙江省");
        tree.insertLastChild(zj, "杭州市");
        tree.insertLastChild(zj, "宁波市");
        tree.insertLastChild(zj, "温州市");
        TreeNode<String> korea = tree.insertLastSibling(tree.root, "韩国");
        tree.insertLastChild(korea, "首尔");
        TreeNode<String> usa = tree.insertLastSibling(korea, "美国");
        tree.insertLastChild(usa, "华盛顿");
        return tree;
	}
}