package graph;

import list.SeqList;

/**
 * 邻接矩阵表示的带权图类
 */
public class AdjMatrixGraph<T> extends AbstractGraph<T> {

	protected SeqList<T> vertexlist;// 顺序表存储图的顶点集合
	protected int[][] adjmatrix; // 图的邻接矩阵
	private final int MAX_WEIGHT = 99999;// 最大权值

	// 构造空图，size指定顺序表的容量和邻接矩阵二维数组的容量
	public AdjMatrixGraph(int size) {
		size = size < 10 ? 10 : size;
		this.vertexlist = new SeqList<T>(size);
		this.adjmatrix = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				this.adjmatrix[i][j] = (i == j) ? 0 : MAX_WEIGHT;// 边的权值为0或最大权值
	}

	// 以顶点集合和边集合构造图
	public AdjMatrixGraph(T[] vertices, Edge[] edges) {
		this(vertices.length);

		if (vertices != null)// 构造空图，没有顶点没有边
			for (int i = 0; i < vertices.length; i++)
				insertVertex(vertices[i]);

		if (edges != null)// 当edges==null，构造的图没有边
			for (int j = 0; j < edges.length; j++)
				insertEdge(edges[j]);
	}

	// 返回顶点的个数
	public int vertexCount() {
		return this.vertexlist.length();// 返回顶点顺序表的元素个数
	}

	// 返回顶点vi的数据元素，若i指定序号无效则返回null
	public T get(int i) {
		return this.vertexlist.get(i);
	}

	// 返回<vi,vj>的权值
	public int getWeight(int i, int j) {
		return this.adjmatrix[i][j];
	}

	// 返回图的顶点集合和邻接矩阵描述字符串
	public String toString() {
		String str = "顶点集合：" + this.vertexlist.toString() + "\n 邻接矩阵：  \n";
		int n = this.vertexCount();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				str += this.adjmatrix[i][j] == MAX_WEIGHT ? "    ∞" : "     "
						+ this.adjmatrix[i][j];
			str += "\n";
		}

		return str;
	}

	// 插入一个顶点
	public int insertVertex(T x) {
		this.vertexlist.append(x);// 顺序表追加元素，自动扩充容量
		if (this.vertexCount() > this.adjmatrix.length) {// 若二维数组容量不足，则扩充
			int temp[][] = adjmatrix, i, j;
			this.adjmatrix = new int[temp.length * 2][temp.length * 2];// 二维数组扩充2倍
			for (i = 0; i < temp.length; i++) {
				for (j = 0; j < temp.length; j++)
					// 复制原邻接矩阵
					this.adjmatrix[i][j] = temp[i][j];// 复制原邻接矩阵
				for (j = temp.length; j < temp.length * 2; j++)
					this.adjmatrix[i][j] = MAX_WEIGHT;
			}

			// 初始化扩充的邻接矩阵
			for (i = temp.length; i < temp.length * 2; i++)
				for (j = 0; j < temp.length * 2; j++)
					this.adjmatrix[i][j] = (i == j) ? 0 : MAX_WEIGHT;
		}
		return this.vertexlist.length() - 1;// 返回插入顶点的序号
	}

	// 插入一条边
	public void insertEdge(int i, int j, int weight) {
		int n = this.vertexCount();
		if (i >= 0 && i < n && j >= 0 && j < n && i != j
				&& this.adjmatrix[i][j] == MAX_WEIGHT)
			this.adjmatrix[i][j] = weight;
	}

	// 插入一条边
	public void insertEdge(Edge edge) {
		this.insertEdge(edge.start, edge.dest, edge.weight);
	}

	// 删除一条边
	public void removeEdge(int i, int j) {
		if (i >= 0 && i < vertexCount() && j >= 0 && j < vertexCount()
				&& i != j) {
			this.adjmatrix[i][j] = MAX_WEIGHT;// 设置该边的权值为无穷大
		}
	}

	// 删除顶点vi
	public void removeVertex(int i) {
		int n = this.vertexCount();// 顶点数
		if (i < 0 || i > n)
			return;
		this.vertexlist.remove(i);// 删除顺序表的第i个元素，顶点数已减一
		for (int j = 0; j < i; j++)
			for (int k = i + 1; k < n; k++)
				this.adjmatrix[j][k - 1] = this.adjmatrix[j][k];// 元素左移一列
		for (int j = i + 1; j < n; j++)
			for (int k = 0; k < i; k++)
				this.adjmatrix[j - 1][k] = this.adjmatrix[j][k];// 元素上移一列

		for (int j = i + 1; j < n; j++)
			for (int k = i + 1; k < n; k++)
				this.adjmatrix[j - 1][k - 1] = this.adjmatrix[j][k];// 元素左上移一行或一列
	}

	@Override
	// 返回//返回vi在vj的下一个邻接矩阵顶点序号
	// 当j = -1时，返回vi的第一个邻接顶点序号，若不存在邻接顶点返回-1
	public int getNextNeighbor(int i, int j) {
		int n = this.vertexCount();
		if (i >= 0 && i < n && j >= -1 && j < n && j != i)
			for (int k = j + 1; k < n; k++)
				if (this.adjmatrix[i][k] > 0// 当j=-1时，k从0开始寻找下一个邻接矩阵
						&& this.adjmatrix[i][k] < MAX_WEIGHT)
					return k;
		return -1;
	}
}