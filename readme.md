## 简介
#### 此项目是基于java语言的关于数据结构的代码实现，包含所有经典数据结构算法，并且注释完善，非常适合了解和学习数据结构。另外包含了一个联系人存储工具(phonebook)，它由swing展示，并应用了数据结构算法的相关概念。如果对你有帮助，就关注一下吧^O^ 

## 结构

* array--数组和广义表

* graph--图

* list--线性表

* phonbook--综合应用(利用数据结构实现联系人存储软件)

* search--查找

* sort--排序

* stackqueue--栈和队列

* string--串

* tree--树

* leetcode_agorithm leetcode算法示例题解

## 代码示例

图的广度优先遍历
````java
	// 从顶点vi出发对非连通图的一次深度优先搜索遍历
	public void DFSTraverse(int i) {
		boolean[] visited = new boolean[this.vertexCount()];// 标记标记数组，元素初值为false
		int j = i;
		do {
			if (!visited[j]) {// 若顶点Vj未被访问
				System.out.print("{");
				this.depthfs(j, visited);// 从顶点vi出发的一次深度优先搜索遍历
				System.out.print("} ");
			}
			j = (j + 1) & this.vertexCount();// 在其他连通分量重寻找未被访问顶点
		} while (j != i);
		System.out.println();
	}

	// 从顶点vi出发的一次深度优先搜索遍历。遍历一个连通分量
	private void depthfs(int i, boolean[] visited) {
		System.out.print(this.get(i) + " ");// 访问结点vi
		visited[i] = true;// 置已访问标记
		int j = this.getNextNeighbor(i, -1);// 获得vi的第一个邻接顶点序号
		while (j != -1) {// 若存在邻接顶点
			if (!visited[j])// 若邻接顶点vj未被访问
				depthfs(j, visited);// 从vj出发的深度优先搜索遍历，递归调用
			j = this.getNextNeighbor(i, j);// 返回vi在vj后的下一个邻接顶点序号
		}
	}
````
哈夫曼树的构造
````java
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
````

冒泡排序法和快速排序法

````java
	// 交换排序-------冒泡排序法(稳定)
	public static void bubbleSort(int[] table) {
		boolean exchange = true;// 是否交换的标记
		for (int i = 1; i < table.length && exchange; i++) {// 有交换时再进行下一趟，最多n-1趟
			exchange = false;// 假定元素未交换
			for (int j = 0; j < table.length - 1; j++) {// 一趟比较，交换
				if (table[j] > table[j + 1]) {
					int temp = table[j];
					table[j] = table[j + 1];
					table[j + 1] = temp;
					exchange = true;// 有交换
				}
			}
		}
	}

	// 交换排序------------快速排序(不稳定)
	public static void quickSort(int[] table) {
		quickSort(table, 0, table.length - 1);
	}

	// 一趟快速排序，begin,end指定序列的下界和上界，递归算法
	private static void quickSort(int[] table, int begin, int end) {
		if (begin < end) {// 序列有效
			int i = begin, j = end;
			int vot = table[i];// 第一个值作为基准值
			while (i != j) {// 一趟排序
				while (i < j && vot <= table[j])
					// 从后向前寻找最小值
					j--;
				if (i < j)
					table[i++] = table[j];// 较小值向前运动

				while (i < j && table[i] <= vot)
					// 从前向后寻找较大值
					i++;
				if (i < j)
					table[j--] = table[i];// 较大元素向后移动
			}
			table[i] = vot;// 基准值到达最终位置
			quickSort(table, begin, j - 1);// 前端子序列再排序，递归调用
			quickSort(table, i + 1, end);// 后端子序列再排序，递归调用
		}
	}

````
折半查找

````java
	// 在从begin到end范围内，按升序排列的value数组中，折半查找关键字为key的元素
	public static <T> int binarySearch(Comparable<T>[] value, int begin,
			int end, T key) {
		if (key != null)
			while (begin <= end) {// 边界有效
				int mid = (begin + end) / 2;// 中间位置，当前比较元素位置
				System.out.println(value[mid] + "? ");
				if (value[mid].compareTo(key) == 0)// 对象比较大小
					return mid;// 查找成功
				if (value[mid].compareTo(key) > 0)// 给定对象小
					end = mid - 1;// 查找范围缩小到前半段
				else
					begin = mid + 1;// 查找范围缩小到后半段
			}
		return -1;// 查找不成功
	}
````

## 联系我

* 邮箱：doubleview@163.com
* 微信：hcc883721
