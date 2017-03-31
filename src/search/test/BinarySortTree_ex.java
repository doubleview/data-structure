package search.test;

import search.BinarySortTree;

/**
 *
 * 二叉排序树的插入和查找操作
 */
public class BinarySortTree_ex {

	public static void main(String[] args) {
		BinarySortTree<Integer> bstree = new BinarySortTree<Integer>();// 构造空二叉排序树
		int[] value = { 54, 18, 66, 87, 36, 12, 54, 81, 15, 76, 57, 6, 40, 99,
				85, 99 };
		for (int i = 0; i < value.length; i++) {
			bstree.insert(new Integer(value[i]));
		}

		bstree.inOrder();// 中跟次序遍历二叉排序树，得到关键字升序排列的数据元素序列
		Integer key = new Integer(value[value.length - 1]);
		System.out.println("查找" + key + ","
				+ (bstree.search(key) != null ? "" : "不") + "成功");
	}
}
