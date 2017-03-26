package tree.test;

import tree.Tree;
import tree.TreeNode;

/**
 * 树的广义表表示及构造
 */
public class Tree_GenList {

	private static int i;

	public static void main(String[] args) {
        String glist = "中国(北京,上海,江苏(南京,苏州,无锡),浙江(杭州,宁波,温州),广东(广州)),韩国(首尔),美国(华盛顿)";
        System.out.println(createByGenList(glist).toGenListString());

	}

    // 以广义表表示构造树
    public static Tree<String> createByGenList(String glist) {
		Tree<String> tree = new Tree<String>();
		i = 0;
		if (glist.length() > 0)
			tree.root = create(glist);
		return tree;
	}

    // 以广义表表示创建一颗子树，子树根结点值是glist[i]，返回子树的根结点，递归调用
    public static TreeNode<String> create(String glist) {
		TreeNode<String> p = null;
		int j = i + 1;
		if (j < glist.length()) {
			char ch = glist.charAt(j);
            while (ch != '(' && ch != ',' && ch != ')') {// 识别字符串作为结点元素值
                j++;
				ch = glist.charAt(j);
			}
		}
        p = new TreeNode<String>(glist.substring(i, j));// 创建结点
        i = j;
        if (i < glist.length() && glist.charAt(i) == '(') {// 遇到（创建子树
            i++;// 跳过'('
            p.child = create(glist);// 创建子树，递归调用
        }
        if (i < glist.length() && glist.charAt(i) == ',') {// 遇到','，创建下一个兄弟子树
            i++;// 跳过','
            p.sibling = create(glist);// 创建下一个兄弟子树，递归调用
        }
        if (i < glist.length() && glist.charAt(i) == ')')// 遇到）子树创建完成
            i++;// 跳过')'
        return p;// 空串返回nul
    }
}