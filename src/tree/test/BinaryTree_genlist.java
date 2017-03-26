package tree.test;

import tree.BinaryNode;
import tree.BinaryTree;

/**
 * 本例以广义表构造和输出一颗二叉树存储的二叉树
 */
public class BinaryTree_genlist {
	private static int i = 0;

	public static void main(String[] args) {
		String glist = "A(B(D(^,G),^),C(E,F(H,^)))";
		BinaryTree<String> bitree = createbyGenList(glist);
		System.out.println(bitree.toGenListString());
	}

    // 以广义表表示构造二叉树
    public static BinaryTree<String> createbyGenList(String glist) {
		BinaryTree<String> bitree = new BinaryTree<String>();
		i = 0;
		if (glist.length() > 0)
            bitree.root = create(glist);// 创建子树，子树跟值是glist[0]
        return bitree;
	}

    // 以广义表表示创建爱你一颗子树，子树跟值是glist[i]，返回根结点，递归结点
    private static BinaryNode<String> create(String glist) {
		BinaryNode<String> p = null;
		char ch = glist.charAt(i);
        if (ch >= 'A' && ch <= 'Z') {// 大写字母
            p = new BinaryNode<String>(ch + "");// 创建叶子结点
            i++;
			if (glist.charAt(i) == '(') {
                i++;// //跳过‘（’
                p.left = create(glist);// 创建左子树，递归调用
                i++;// 跳过','
                p.right = create(glist);// 创建右子树
                i++;// 跳过')'
            }
		}
		if (ch == '^')
            i++;// 跳过‘^’
        return p;// 空串返回null
    }
}