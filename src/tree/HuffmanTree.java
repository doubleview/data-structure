package tree;

/**
 * Hufman树
 */
public class HuffmanTree {

	private int leafNum;// 叶子结点个数
	private TriElement[] huftree;// HuffmanTree的节点数组

	public HuffmanTree(int[] weight) {
		int n = weight.length;// n个叶子节点
		this.leafNum = n;
		this.huftree = new TriElement[2 * n - 1];// n个叶子节点的Huffman树共有2n-1个结点
		// 结点数组初始化共有n个结点
		for (int i = 0; i < n; i++)
			this.huftree[i] = new TriElement(weight[i]);
		for (int i = 0; i < n - 1; i++) {// 构造n-1个2度结点，每次循环构造1个2度结点
			int min1 = Integer.MAX_VALUE, min2 = min1;// 最小和次最小权值
			int x1 = -1, x2 = -1;// 记录两个无父母的最小权值的节点下标
			for (int j = 0; j < n + i; j++) {
				if (huftree[j].data < min1 && huftree[j].parent == -1) {
					min2 = min1;
					x2 = x1;
					min1 = huftree[j].data;// min1记下最小权值
					x1 = j;// x1记下最小权值结点的下标
				} else if (huftree[j].data < min2 && huftree[j].parent == -1) {
					min2 = huftree[j].data;
					x2 = j;// x2记下最小权值结点的下标
				}
			}
			huftree[x1].parent = n + i;// 将找出的两颗权值最小的子树合并为一颗子树
			huftree[x2].parent = n + i;
			this.huftree[n + i] = new TriElement(huftree[x1].data
					+ huftree[x2].data, -1, x1, x2);
		}
	}

	public String toString() {
		String str = "Huffman树的结点数组:\n";
		for (int i = 0; i < this.huftree.length && huftree[i] != null; i++) {
			str += "第" + i + "行  " + this.huftree[i].toString() + "\n";
		}
		return str;
	}

	// 返回当前hufman树的哈夫曼编码
	public String[] hufmanCodes() {
		String[] hufcodes = new String[this.leafNum];
		for (int i = 0; i < this.leafNum; i++) {// 求n个结点的Hufman编码
			hufcodes[i] = "";
			int child = i;
			int parent = huftree[child].parent;
			while (parent != -1) {// 由叶结点向上直到根节点循环
				if (huftree[parent].left == child)
					hufcodes[i] = "0" + hufcodes[i];// 左孩子编码为0
				else
					hufcodes[i] = "1" + hufcodes[i];// 右孩子编码为1
				child = parent;
				parent = huftree[child].parent;
			}
		}
		return hufcodes;
	}
}